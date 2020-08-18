package com.az.signup.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.az.signup.R
import com.az.signup.databinding.FragmentSignupBinding
import com.az.signup.di.signupViewModelModule
import com.az.signup.viewmodel.SignupViewModel
import com.az.youtugo.AzToast
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

val loadFeature by lazy { loadKoinModules(signupViewModelModule) }

class SignupFragment : Fragment(R.layout.fragment_signup) {

    private fun injectFeature() = loadFeature

    private val viewModel: SignupViewModel by viewModel()

    private var _binding: FragmentSignupBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignupBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        injectFeature()
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            lifecycleOwner = requireActivity()
            vm = viewModel
        }
        setViewModelHandlers()
    }

    private fun setViewModelHandlers() {
        viewModel.run {
            toastMessageHandler = { showToast(it) }
            toBackStackHandler = { findNavController().popBackStack() }
        }
    }

    private fun showToast(message: String) {
        AzToast(requireActivity()).showToast(message)
    }
}