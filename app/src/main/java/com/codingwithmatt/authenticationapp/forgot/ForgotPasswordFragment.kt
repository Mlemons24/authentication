package com.codingwithmatt.authenticationapp.forgot

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
import com.codingwithmatt.authenticationapp.databinding.ForgotPasswordFragmentBinding

class ForgotPasswordFragment : Fragment() {

    companion object {
        fun newInstance() = ForgotPasswordFragment()
    }
    private val userDao by lazy{ AppDatabase.getInstance(requireContext()).userDao()}
    private val viewModel: ForgotPasswordViewModel by viewModels {
        VMFactory(UserRepo(userDao))
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