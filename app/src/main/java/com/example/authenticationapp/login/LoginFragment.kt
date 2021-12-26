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
import com.example.authenticationapp.R
import androidx.fragment.app.viewModels
import com.example.authenticationapp.data.UserRepo
import com.example.authenticationapp.forgot.ForgotPasswordFragment
import com.example.authenticationapp.register.RegisterFragment
import java.net.PasswordAuthentication

class LoginFragment : Fragment() {

    companion object {
        fun newInstance() = LoginFragment()
    }

    private val viewModel: LoginViewModel by viewModels{
        LoginVMFactory(UserRepo())
    }

    private lateinit var emailET:EditText
    private lateinit var passwordET:EditText
    private lateinit var loginBTN:Button
    private lateinit var registerBTN:Button
    private lateinit var forgotpass:TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =inflater.inflate(R.layout.login_fragment, container, false)
        emailET= view?.findViewById(R.id.email_et)!!
        passwordET= view?.findViewById(R.id.password_et)!!
        loginBTN= view?.findViewById(R.id.login_btn)!!
        registerBTN= view?.findViewById(R.id.registration_btn)!!
        forgotpass= view?.findViewById(R.id.forgot_password)!!

        loginBTN.setOnClickListener {
            Log.d("click","clickedloginbtn")
        }

        registerBTN.setOnClickListener {
            Log.d("click","clickedregisterbtn")
            requireActivity().supportFragmentManager.beginTransaction()
                .add(R.id.container,RegisterFragment.newInstance(),"register")
                .addToBackStack("register")
                .commit()


        }
        forgotpass.setOnClickListener {
            Log.d("click","clickedforgotpasswordbtn")
            requireActivity().supportFragmentManager.beginTransaction()
                .add(R.id.container,ForgotPasswordFragment.newInstance(),"forgotpass")
                .addToBackStack("forgotpass")
                .commit()
            }

        return view
    }



}