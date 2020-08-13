package com.az.mypage.ui.views

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.az.mypage.R
import com.az.mypage.databinding.FragmentMyPageBinding
import kotlinx.android.synthetic.main.layout_tab.*

class MyPageFragment : Fragment(R.layout.fragment_my_page) {

    private var _binding: FragmentMyPageBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMyPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_my_bookmark.setOnClickListener {
            Log.d("TAG", "click bookmark")
        }
        btn_my_comment.setOnClickListener {
            Log.d("TAG", "click comment")
        }
        btn_my_setting.setOnClickListener {
            Log.d("TAG", "click setting")
        }
        btn_my_write.setOnClickListener {
            Log.d("TAG", "click write")
        }
    }
}