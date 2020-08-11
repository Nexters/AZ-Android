package com.az.login.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.az.core.Preferences
import com.az.core.Resource
import com.az.core.Status
import com.az.core.data.auth.response.SignInResponseData
import com.az.login.R
import com.az.login.databinding.FragmentLoginBinding
import com.az.login.di.loginViewModelModule
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

val loadFeature by lazy { loadKoinModules(loginViewModelModule) }

class LoginFragment : Fragment(R.layout.fragment_login) {

    private fun injectFeature() = loadFeature
    private val sharedPrefs: Preferences by inject()

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
        _binding = FragmentLoginBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
            vm = viewModel
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSignup.setOnClickListener { toSignupPage() }
        binding.txtForgotPassword.setOnClickListener { toForgotPassworPage() }

        observer()
    }

    private fun toSignupPage() {
        val action =
            LoginFragmentDirections.actionLoginFragmentToSignupFragment()
        findNavController().navigate(action)
    }

    private fun toForgotPassworPage() {
        val action = LoginFragmentDirections.actionLoginFragmentToForgotFragment()
        findNavController().navigate(action)
    }

    private fun toMainPage() {
        val action = LoginFragmentDirections.actionLoginFragmentToMainFragment()
        findNavController().navigate(action)
    }

    private fun observer() {
        viewModel.login.observe(viewLifecycleOwner, loginObserver)
    }

    private val loginObserver = Observer<Resource<SignInResponseData>> {
        when (it.status) {
            Status.SUCCESS -> {
                sharedPrefs.setLoginSession(it.data!!)
                toMainPage()
            }
            Status.ERROR -> Log.e("Error", it.message)
        }
    }
}