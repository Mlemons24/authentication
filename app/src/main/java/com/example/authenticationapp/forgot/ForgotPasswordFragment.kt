package com.example.authenticationapp.forgot

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.authenticationapp.R
import com.example.authenticationapp.VMFactory
import com.example.authenticationapp.data.UserRepo
import com.example.authenticationapp.databinding.ForgotPasswordFragmentBinding

class ForgotPasswordFragment : Fragment() {

    companion object {
        fun newInstance() = ForgotPasswordFragment()
    }

    private val viewModel: ForgotPasswordViewModel by viewModels {
        VMFactory(UserRepo())
    }

    private lateinit var binding: ForgotPasswordFragmentBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        binding =
            DataBindingUtil.inflate(inflater, R.layout.forgot_password_fragment, container, false)


        binding.confirmButton.setOnClickListener {
            Log.d("click", "clickedconfirmbutton")
            requireActivity().supportFragmentManager.popBackStack()
        }

        return binding.root

    }


}