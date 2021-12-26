package com.example.authenticationapp.login

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.authenticationapp.R
import androidx.fragment.app.viewModels
import com.example.authenticationapp.data.UserRepo
import com.example.authenticationapp.databinding.LoginFragmentBinding
import com.example.authenticationapp.forgot.ForgotPasswordFragment
import com.example.authenticationapp.register.RegisterFragment
import java.net.PasswordAuthentication

class LoginFragment : Fragment() {

    companion object {
        fun newInstance() = LoginFragment()
    }

    private val viewModel: LoginViewModel by viewModels {
        LoginVMFactory(UserRepo())
    }
    private lateinit var binding: LoginFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.login_fragment, container, false)

        binding.loginBtn.setOnClickListener {
            Log.d("click", "clickedloginbtn")
        }

        binding.registrationBtn.setOnClickListener {
            Log.d("click", "clickedregisterbtn")
            requireActivity().supportFragmentManager.beginTransaction()
                .add(R.id.container, RegisterFragment.newInstance(), "register")
                .addToBackStack("register")
                .commit()


        }
        binding.forgotPassword.setOnClickListener {
            Log.d("click", "clickedforgotpasswordbtn")
            requireActivity().supportFragmentManager.beginTransaction()
                .add(R.id.container, ForgotPasswordFragment.newInstance(), "forgotpass")
                .addToBackStack("forgotpass")
                .commit()
        }

        return binding.root
    }


}