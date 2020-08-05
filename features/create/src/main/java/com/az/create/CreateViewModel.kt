package com.az.create

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CreateViewModel : ViewModel() {

    val humorText = MutableLiveData<String>()

    init {
        humorText.value = ""
    }

}