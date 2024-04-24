package com.jz.app

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import com.jz.lib_common.network.RetrofitApi

class BusinessApplication : Application(){

    companion object{
        var application = this

    }



    override fun onCreate() {
        super.onCreate()

        RetrofitApi.initNetInfo(HttpBaseInfo(),ErrorHandler())

    }
}