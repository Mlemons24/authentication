package com.codingwithmatt.authenticationapp.register

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
import com.codingwithmatt.authenticationapp.databinding.RegisterFragmentBinding

class RegisterFragment : Fragment() {

    companion object {
        fun newInstance() = RegisterFragment()
    }
    private val userDao by lazy{ AppDatabase.getInstance(requireContext()).userDao()}
    private val viewModel: RegisterViewModel by viewModels {
        VMFactory(UserRepo(userDao))
    }
    private lateinit var binding: RegisterFragmentBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.register_fragment, container, false)

        binding.registrationBtn.setOnClickListener {
            Log.d("click", "clickedregisterbtn")
            viewModel.registerUser(
                binding.emailEt.text.toString(),
                binding.firstnameEt.text.toString(),
                binding.lastnameEt.text.toString(),
                binding.passwordEt.text.toString()
            )

        }
        return binding.root


    }

}