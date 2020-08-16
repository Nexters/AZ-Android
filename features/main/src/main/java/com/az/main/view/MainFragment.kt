package com.az.main.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.az.infinite_recyclerview.InfiniteFragment
import com.az.main.adapter.MainHumorsAdapter
import com.az.main.adapter.holder.listener.HumorItemListener
import com.az.main.databinding.FragmentMainBinding
import com.az.main.di.loadFeature
import com.az.main.viewmodel.MainViewModel
import com.az.model.posts.PostData
import com.az.youtugo.AzToast
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
            fabCreateHumor.setOnClickListener { toCreatePage() }
        }
        observeToast()
    }

    override fun onResume() {
        super.onResume()
        hideSoftInput()
    }

    private fun getHumorItemListener(): HumorItemListener {
        return object : HumorItemListener {
            override fun onClickHumorItem(postId: Int) = toDetailPage(postId)
        }
    }

    private fun toDetailPage(postId: Int) {
        MainFragmentDirections.actionMainFragmentToDetailsFragment(postId)
            .let { action -> findNavController().navigate(action) }
    }

    private fun toCreatePage() {
        if (viewModel.isGuestLogin()) {
            showToast("가입이 필요한 서비스입니다")
            return
        }
        MainFragmentDirections.actionMainFragmentToCreateFragment()
            .let { action -> findNavController().navigate(action) }
    }

    private fun hideSoftInput() {
        getInputMethodManager().hideSoftInputFromWindow(view?.windowToken, 0)
    }

    private fun getInputMethodManager(): InputMethodManager {
        return requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    }

    private fun observeToast() {
        viewModel.toastMessage.observe(viewLifecycleOwner, Observer {
            if (!it.isNullOrBlank()) showToast(it)
        })
    }

    private fun showToast(message: String) {
        AzToast(requireActivity()).showToast(message)
    }
}