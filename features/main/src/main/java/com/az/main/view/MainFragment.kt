package com.az.main.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import androidx.navigation.fragment.findNavController
import com.az.infinite_recyclerview.InfiniteFragment
import com.az.main.adapter.MainHumorsAdapter
import com.az.main.adapter.holder.listener.HumorItemListener
import com.az.main.databinding.FragmentMainBinding
import com.az.main.di.loadFeature
import com.az.main.viewmodel.MainViewModel
import com.az.model.posts.PostData
import com.az.youtugo.AzToast
import com.az.youtugo.R
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
        }
        setSoftInputMode()
        setViewModelHandlers()
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

    private fun setSoftInputMode() {
        requireActivity().window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_UNSPECIFIED)
    }

    private fun toDetailPage(postId: Int) {
        MainFragmentDirections.actionMainFragmentToDetailsFragment(postId)
            .let { action -> findNavController().navigate(action) }
    }

    private fun toCreatePage() {
        MainFragmentDirections.actionMainFragmentToCreateFragment()
            .let { action -> findNavController().navigate(action) }
    }

    private fun toLoginPage() {
        findNavController().navigate(R.id.loginFragment)
    }

    private fun hideSoftInput() {
        getInputMethodManager().hideSoftInputFromWindow(view?.windowToken, 0)
    }

    private fun getInputMethodManager(): InputMethodManager {
        return requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    }

    private fun setViewModelHandlers() {
        viewModel.run {
            toastMessageHandler = { showToast(it) }
            toCreatePageHandler = { toCreatePage() }
            toLoginPageHandler = { toLoginPage() }
        }
    }

    private fun showToast(message: String) {
        AzToast(requireActivity()).showToast(message)
    }
}