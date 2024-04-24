package com.jz.app

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AppViewModel : ViewModel() {

    private var showToast = MutableLiveData<String>()

    fun showShortToast(msg: String) {

        showToast.postValue(msg)
    }


}