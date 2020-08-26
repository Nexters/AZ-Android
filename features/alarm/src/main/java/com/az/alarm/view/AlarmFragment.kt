package com.az.alarm.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.az.alarm.adapter.AlarmsAdapter
import com.az.alarm.databinding.FragmentAlarmBinding
import com.az.alarm.di.loadFeature
import com.az.alarm.viewmodel.AlarmViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class AlarmFragment : Fragment() {
    private fun injectFeature() = loadFeature
    private var _binding: FragmentAlarmBinding? = null
    private val binding get() = _binding!!

    private val viewModel: AlarmViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAlarmBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        injectFeature()
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            lifecycleOwner = requireActivity()
            vm = viewModel
            alarmRv.adapter = AlarmsAdapter()
        }
    }
}