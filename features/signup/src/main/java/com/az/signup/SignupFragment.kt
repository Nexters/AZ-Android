package com.az.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.az.signup.databinding.FragmentSignupBinding
import com.az.signup.di.signupViewModelModule
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

val loadFeature by lazy { loadKoinModules(signupViewModelModule) }

class SignupFragment : Fragment(R.layout.fragment_signup) {

    private fun injectFeature() = loadFeature

    private val viewModel: SignupViewModel by viewModel()

    private var _binding: FragmentSignupBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectFeature()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignupBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
            vm = viewModel
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observerEditText()
        binding.btnSignup.setOnClickListener {
            viewModel.onClick()
        }
    }

    private fun observerEditText() {

        viewModel.id.observe(viewLifecycleOwner, Observer {
            viewModel.validId()
            viewModel.validSignUp()
        })
        viewModel.nickname.observe(viewLifecycleOwner, Observer {
            viewModel.validNickname()
            viewModel.validSignUp()
        })
        viewModel.password.observe(viewLifecycleOwner, Observer {
            viewModel.validPassword()
            viewModel.validSignUp()
        })
        viewModel.passwordCheck.observe(viewLifecycleOwner, Observer {
            viewModel.validPassword()
            viewModel.validSignUp()
        })
    }

}