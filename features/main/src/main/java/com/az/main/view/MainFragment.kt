package com.az.main.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.az.infinite_recyclerview.InfiniteFragment
import com.az.main.adapter.MainHumorsAdapter
import com.az.main.adapter.holder.listener.HumorItemListener
import com.az.main.databinding.FragmentMainBinding
import com.az.main.di.loadFeature
import com.az.main.viewmodel.MainViewModel
import com.az.model.posts.PostData
import kotlinx.android.synthetic.main.bottom_sheet_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainFragment : InfiniteFragment<MainViewModel, PostData>() {
    private fun injectFeature() = loadFeature

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override val viewModel: MainViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        injectFeature()
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            lifecycleOwner = requireActivity()
            vm = viewModel
            humor_card_rv.adapter = MainHumorsAdapter(getHumorItemListener())
            setRecyclerViewScrollListener(humor_card_rv)
            fabCreateHumor.setOnClickListener { toCreatePage.invoke() }
        }
    }

    private fun getHumorItemListener(): HumorItemListener {
        return object : HumorItemListener {
            override fun onClickHumorItem(postId: Int) {
                toDetailPage(postId)
            }
        }
    }

    private fun toDetailPage(postId: Int) {
        MainFragmentDirections.actionMainFragmentToDetailsFragment(postId)
            .let { action -> findNavController().navigate(action) }
    }

    private val toCreatePage: () -> Unit = {
        MainFragmentDirections.actionMainFragmentToCreateFragment()
            .let { action -> findNavController().navigate(action) }
    }
}