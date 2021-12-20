package com.example.authenticationapp.register

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

class RegisterFragment : Fragment() {

    companion object {
        fun newInstance() = RegisterFragment()
    }

    private val viewModel: RegisterViewModel by viewModels {
        RegisterVMFactory(UserRepo())
    }

    private lateinit var firstname: EditText
    private lateinit var lastname: EditText
    private lateinit var emailET: EditText
    private lateinit var passwordET: EditText
    private lateinit var confirmpassword: EditText
    private lateinit var registerBTN: Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =inflater.inflate(R.layout.register_fragment, container, false)

        firstname = view?.findViewById(R.id.firstname_et)!!
        lastname = view?.findViewById(R.id.lastname_et)!!
        emailET = view?.findViewById(R.id.email_et)!!
        passwordET = view?.findViewById(R.id.password_et)!!
        confirmpassword = view?.findViewById(R.id.confirmpassword_et)!!
        registerBTN = view?.findViewById(R.id.registration_btn)!!


        registerBTN.setOnClickListener {
            Log.d("click", "clickedregisterbtn")
            requireActivity().supportFragmentManager.popBackStack()

        }
        return view

    }
}