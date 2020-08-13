package com.az.infinite_recyclerview.example

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.az.infinite_recyclerview.InfiniteFragment
import com.az.infinite_recyclerview.databinding.FragmentInfiniteRecyclerExampleBinding

class InfiniteRecyclerExampleFragment :
    InfiniteFragment<InfiniteRecyclerExampleViewModel, ExampleData>() {
    override val viewModel = InfiniteRecyclerExampleViewModel()

    private var _binding: FragmentInfiniteRecyclerExampleBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInfiniteRecyclerExampleBinding
            .inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            lifecycleOwner = requireActivity()
            vm = viewModel
            exampleRv.adapter = InfiniteAdapter()
            setRecyclerViewScrollListener(exampleRv)
        }
    }
}