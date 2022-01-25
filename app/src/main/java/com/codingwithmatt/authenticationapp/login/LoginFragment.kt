package com.codingwithmatt.authenticationapp.login

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.codingwithmatt.authenticationapp.R
import com.codingwithmatt.authenticationapp.VMFactory
import com.codingwithmatt.authenticationapp.data.AppDatabase
import com.codingwithmatt.authenticationapp.data.UserRepo
import com.codingwithmatt.authenticationapp.databinding.LoginFragmentBinding
import com.codingwithmatt.authenticationapp.forgot.ForgotPasswordFragment
import com.codingwithmatt.authenticationapp.register.RegisterFragment
import com.codingwithmatt.authenticationapp.welcome.WelcomeFragment

class LoginFragment : Fragment() {

    companion object {
        fun newInstance() = LoginFragment()
    }

    private val userDao by lazy {AppDatabase.getInstance(requireContext()).userDao()}
    private val viewModel: LoginViewModel by viewModels {
        VMFactory(UserRepo(userDao))
    }
    private lateinit var binding: LoginFragmentBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.login_fragment, container, false)

        viewModel.user.observe(viewLifecycleOwner,{
            requireActivity().supportFragmentManager.beginTransaction()
                .add(R.id.container, WelcomeFragment.newInstance(), "welcome")
                .addToBackStack("welcome")
                .commit()
        })

        binding.loginBtn.setOnClickListener {
            Log.d("click", "clickedloginbtn")
            viewModel.login(binding.emailEt.text.toString(),
                binding.passwordEt.text.toString())
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