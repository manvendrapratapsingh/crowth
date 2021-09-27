package com.know.myapplication.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NetofnetsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is NetsofNets Fragment"
    }
    val text: LiveData<String> = _text
}