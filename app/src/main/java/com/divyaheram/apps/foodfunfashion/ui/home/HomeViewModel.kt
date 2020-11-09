package com.divyaheram.apps.foodfunfashion.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Welcome to \"Food Fun Fashion\""
    }
    val text: LiveData<String> = _text
}
