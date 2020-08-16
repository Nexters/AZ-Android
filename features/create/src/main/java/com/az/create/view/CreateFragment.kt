package com.az.create.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.az.create.databinding.FragmentCreateBinding
import com.az.create.di.loadFeature
import com.az.create.viewmodel.CreateViewModel
import com.az.youtugo.AzToast
import com.az.youtugo.MainActivity
import com.az.youtugo.ToolbarListener
import kotlinx.android.synthetic.main.fragment_create.*
import org.koin.android.viewmodel.ext.android.viewModel

class CreateFragment : Fragment() {

    companion object {
        private const val DELAY_TO_SHOW_SOFT_INPUT = 30L
    }

    private fun injectFeature() = loadFeature
    private var _binding: FragmentCreateBinding? = null
    private val binding get() = _binding!!

    private val viewModel: CreateViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCreateBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        injectFeature()
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            lifecycleOwner = requireActivity()
            vm = viewModel
            humorInput.requestFocus()
        }
        setSoftInputMode()
        setViewModelHandlers()
        setPostCompleteButtonListener()
    }

    private fun setPostCompleteButtonListener() {
        (activity as MainActivity).listener = object : ToolbarListener {
            override fun onClickPostCompleteButton() {
                viewModel.createPost()
            }
        }
    }

    private fun closeCreatePage() {
        findNavController().popBackStack()
    }

    private fun setSoftInputMode() {
        requireActivity().window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
    }

    private fun showSoftInput() {
        getInputMethodManager().showSoftInput(humor_input, 0)
    }

    private fun getInputMethodManager(): InputMethodManager {
        return requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    }

    private fun setViewModelHandlers() {
        viewModel.run {
            toastMessageHandler = { showToast(it) }
            showSoftInputHandler = { showSoftInput() }
            closeCreatePageHandler = { closeCreatePage() }
        }.also { viewModel.showSoftInputHandler?.invoke() }
    }

    private fun showToast(message: String) {
        AzToast(requireActivity()).showToast(message)
    }
}