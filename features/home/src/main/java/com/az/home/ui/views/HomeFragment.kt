package com.az.home.ui.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.az.home.R
import com.az.home.databinding.FragmentHomeBinding
import com.az.home.ui.di.loadModules
import com.az.home.ui.viewModel.HomeFragmentVm
import com.az.model.github.InfoModel
import kotlinx.android.synthetic.main.fragment_home.view.*
import org.koin.android.viewmodel.ext.android.viewModel

private fun injectFeature() = loadModules

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val vm: HomeFragmentVm by viewModel()

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        injectFeature()
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        vm.githubInfo.observe(viewLifecycleOwner, observer)
        return binding.root
    }

    private val observer = Observer<InfoModel> {
        binding.txtHomeFragment.txt_home_fragment.text = "${it.id} / ${it.name} ${it.company}"
    }
}