package com.jz.app

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import com.jz.lib_common.network.error.BusinessException
import com.jz.lib_common.network.error.IGlobalError
import com.jz.lib_common.utils.LogUtils

class ErrorHandler : IGlobalError {

    override fun onFailure(throwable: BusinessException) {

        LogUtils.d("ErrorHandler", "业务自己处理各种错误code = " + throwable.code)

        when (throwable.code) {
            101 -> {


            }

            102 -> {
                LogUtils.d("GlobalErrorHandler", "")
            }

            else -> {
                LogUtils.d("ErrorHandler", "业务自己处理错误 ")
            }
        }


    }
}