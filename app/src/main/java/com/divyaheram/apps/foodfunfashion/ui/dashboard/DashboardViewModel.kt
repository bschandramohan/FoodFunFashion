package com.divyaheram.apps.foodfunfashion.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DashboardViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Food Fun Fashion"
    }
    val text: LiveData<String> = _text
}