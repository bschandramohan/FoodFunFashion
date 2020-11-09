package com.divyaheram.apps.foodfunfashion.ui.notifications

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NotificationsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "No new notifications currently"
    }
    val text: LiveData<String> = _text
}