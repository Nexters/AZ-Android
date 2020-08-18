package com.az.mypage.ui.views

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.az.infinite_recyclerview.InfiniteFragment
import com.az.main.view.MainFragmentDirections
import com.az.model.BaseDataInterface
import com.az.mypage.adapter.MyPageRecyclerViewAdapter
import com.az.mypage.adapter.holder.listener.HumorItemListener
import com.az.mypage.adapter.holder.listener.SettingItemListener
import com.az.mypage.databinding.FragmentMyPageBinding
import com.az.mypage.di.loadFeature
import com.az.mypage.model.MyPageItemCode
import com.az.mypage.model.SettingKey
import com.az.mypage.ui.viewModel.MyPageViewModel
import kotlinx.android.synthetic.main.layout_bottom_sheet.*
import kotlinx.android.synthetic.main.layout_tab.*
import org.koin.android.viewmodel.ext.android.viewModel

class MyPageFragment : InfiniteFragment<MyPageViewModel, BaseDataInterface>() {

    private fun injectFeature() = loadFeature

    private var _binding: FragmentMyPageBinding? = null
    private val binding get() = _binding!!

    override val viewModel: MyPageViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMyPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        injectFeature()
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            vm = viewModel
            recycler_view_my_page.adapter = MyPageRecyclerViewAdapter(
                settingItemClickListener(),
                getHumorItemListener()
            )
        }

        btn_my_bookmark.setOnClickListener {
            viewModel.onSelectMyPageItem(MyPageItemCode.MY_BOOKMARKS)
        }
        btn_my_comment.setOnClickListener {
            viewModel.onSelectMyPageItem(MyPageItemCode.MY_COMMENTS)
        }
        btn_my_setting.setOnClickListener {
            viewModel.onSelectMyPageItem(MyPageItemCode.SETTING)
        }
        btn_my_write.setOnClickListener {
            viewModel.onSelectMyPageItem(MyPageItemCode.MY_HUMORS)
        }
    }

    private fun getHumorItemListener(): HumorItemListener {
        return object : HumorItemListener {
            override fun onClickHumorItem(postId: Int) = toDetailPage(postId)
        }
    }

    private fun settingItemClickListener(): SettingItemListener {
        return object : SettingItemListener {
            override fun onClickSettingItem(key: SettingKey) {
                viewModel.onSettingItemClickEvent(key)
                logout()
            }
        }
    }

    private fun toDetailPage(postId: Int) {
        MyPageFragmentDirections.actionMyPageFragmentToDetailsFragment(postId)
            .let { action -> findNavController().navigate(action) }
    }

    fun logout() {
        MyPageFragmentDirections.actionLogout()
            .let { action -> findNavController().navigate(action) }
    }
}