package com.example.authenticationapp.forgot

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.viewModels
import com.example.authenticationapp.R
import com.example.authenticationapp.data.UserRepo
import com.example.authenticationapp.login.LoginVMFactory
import com.example.authenticationapp.login.LoginViewModel

class ForgotPasswordFragment : Fragment() {

    companion object {
        fun newInstance() = ForgotPasswordFragment()
    }
    private val viewModel: ForgotPasswordViewModel by viewModels{
        ForgotVMFactory(UserRepo())
    }
    private lateinit var emailET: EditText
    private lateinit var confirm: Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.forgot_password_fragment, container, false)
        emailET= view?.findViewById(R.id.email_et)!!
       confirm= view?.findViewById(R.id.confirm_button)!!


        confirm.setOnClickListener {
            Log.d("click","clickedconfirmbutton")
            requireActivity().supportFragmentManager.popBackStack()}

        return view
    }



}