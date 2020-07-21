package com.az.home.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.az.model.github.InfoModel
import com.az.repository.github.InfoRepository

class HomeFragmentVm(private val info: InfoRepository) : ViewModel() {

    val githubInfo: LiveData<InfoModel> = liveData {
        emit(info.getInfo("KimHunJin"))
    }
}