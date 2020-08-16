package com.az.signup.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.az.core.Resource
import com.az.core.Status
import com.az.core.data.auth.response.SignInResponseData
import com.az.signup.R
import com.az.signup.databinding.FragmentSignupBinding
import com.az.signup.di.signupViewModelModule
import com.az.signup.viewmodel.SignupViewModel
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
        observeViewModel()

    }

    private fun observeViewModel() {

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

        viewModel.signUp.observe(viewLifecycleOwner, signUpObserver)
    }

    private val signUpObserver = Observer<Resource<SignInResponseData>> {
        when (it.status) {
            Status.SUCCESS -> findNavController().popBackStack()
            Status.ERROR -> Log.e("Error", it.message)
        }
    }


}