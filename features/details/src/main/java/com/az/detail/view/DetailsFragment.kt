package com.az.detail.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.az.detail.adapter.CommentsAdapter
import com.az.detail.databinding.FragmentDetailsBinding
import com.az.detail.di.loadFeature
import com.az.detail.viewmodel.DetailsViewModel
import com.az.infinite_recyclerview.InfiniteFragment
import com.az.model.posts.detail.comments.CommentData
import kotlinx.android.synthetic.main.fragment_details.*
import org.koin.android.viewmodel.ext.android.viewModel

class DetailsFragment : InfiniteFragment<DetailsViewModel, CommentData>() {
    private fun injectFeature() = loadFeature
    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!

    override val viewModel: DetailsViewModel by viewModel()

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
        setSoftInputMode()
        observeHideSoftInput()
    }

    private fun observeHideSoftInput() {
        viewModel.hideSoftInput.observe(viewLifecycleOwner, Observer {
            if (it) hideSoftInput()
        })
    }

    private fun setSoftInputMode() {
        activity?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
    }

    private fun hideSoftInput() {
        val inputMethodManager =
            activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(comment_input.windowToken, 0)
    }
}