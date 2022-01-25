package com.codingwithmatt.authenticationapp.welcome

import android.os.Bundle
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
import com.codingwithmatt.authenticationapp.databinding.WelcomeFragmentBinding

class WelcomeFragment : Fragment() {
    companion object {
        fun newInstance() = WelcomeFragment()
    }

    private val userDao by lazy { AppDatabase.getInstance(requireContext()).userDao() }
    private val viewModel: WelcomeViewModel by viewModels {
        VMFactory(UserRepo(userDao))
    }
    private lateinit var binding: WelcomeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.welcome_fragment, container, false)

        return binding.root


    }