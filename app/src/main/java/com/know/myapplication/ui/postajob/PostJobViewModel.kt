package com.know.myapplication.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PostJobViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Post a Job Fragment"
    }
    val text: LiveData<String> = _text
}