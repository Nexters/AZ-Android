package com.az.detail.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.az.detail.adapter.CommentsAdapter
import com.az.detail.databinding.FragmentDetailsBinding
import com.az.detail.di.loadFeature
import com.az.detail.viewmodel.DetailsViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class DetailsFragment : Fragment() {
    private fun injectFeature() = loadFeature
    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: DetailsViewModel by viewModel()

    private val args: DetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        injectFeature()
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            lifecycleOwner = requireActivity()
            vm = viewModel.apply { setPostId(args.postId) }
            commentsRv.adapter = CommentsAdapter()
        }
    }
}