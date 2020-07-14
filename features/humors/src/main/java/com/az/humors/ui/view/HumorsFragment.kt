package com.az.humors.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.az.humors.R
import com.az.humors.databinding.FragmentHumorsBinding

class HumorsFragment : Fragment(R.layout.fragment_humors) {

    private var _binding: FragmentHumorsBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHumorsBinding.inflate(inflater, container, false)
        return binding.root
    }
}