package com.az.login.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.az.login.R
import com.az.login.databinding.FragmentLoginBinding
import com.az.login.di.loginViewModelModule
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

val loadFeature by lazy { loadKoinModules(loginViewModelModule) }

class LoginFragment : Fragment(R.layout.fragment_login) {

    private fun injectFeature() = loadFeature

    private val viewModel: LoginViewModel by viewModel()

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectFeature()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSignup.setOnClickListener { toSignupPage() }
    }

    fun toSignupPage() {
        val action =
            LoginFragmentDirections.actionLoginFragmentToSignupFragment()
        findNavController().navigate(action)
    }

}