package com.az.create.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.az.create.viewmodel.CreateViewModel
import com.az.create.databinding.FragmentCreateBinding
import com.az.create.di.loadFeature
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
            humorInput.let {
                it.requestFocus()
                /*showSoftInput(it)*/
            }
        }
    }

    private fun showSoftInput(view: EditText) {
        val inputMethodManager =
            activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        // softInput 이 30 mills 동안 delay 되었다가 보여지도록 했음
        view.postDelayed(
            { inputMethodManager.showSoftInput(view, 0) }
            ,
            DELAY_TO_SHOW_SOFT_INPUT
        )
    }
}