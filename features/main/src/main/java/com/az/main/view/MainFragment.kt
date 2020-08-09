package com.az.main.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.az.core.Preferences
import com.az.main.databinding.FragmentMainBinding
import com.az.main.di.loadFeature
import com.az.main.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.bottom_sheet_main.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {
    private fun injectFeature() = loadFeature

    private val sharedPrefs: Preferences by inject()

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MainViewModel by viewModel()

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
            humor_card_rv.adapter = MainHumorsAdapter()
            fabCreateHumor.setOnClickListener { toCreatePage.invoke() }
        }

        // TODO used shared preferences
        val status = sharedPrefs.getLoginStatus()
    }

    private val toCreatePage: () -> Unit = {
        MainFragmentDirections.actionMainFragmentToCreateFragment()
            .let { action -> findNavController().navigate(action) }
    }
}