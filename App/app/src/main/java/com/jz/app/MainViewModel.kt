package com.jz.app

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jz.lib_common.network.MoshiUtils
import com.jz.lib_common.network.core.HttpResult
import kotlinx.coroutines.launch
import retrofit2.http.GET

class MainViewModel:ViewModel() {

    fun onHttpWanHttp() {

        viewModelScope.launch {
            val result = WanAndroidService.getService().getBanner()
            when (result) {
                is HttpResult.Success -> {
                    Log.e("Success", MoshiUtils.toJson(result.data))
                }

                is HttpResult.Failure -> {
                    Log.e("Failure", result.message + "  -----  " + result.code)
                    //通过livaData  处理所有错误 例如 全局模式的弹窗
                }

            }
        }

    }

    fun onHttpEurop(){

        viewModelScope.launch {
            val result = EuropApiService.getService().getBanner()

            when (result) {
                is HttpResult.Success -> {
                    Log.e("Success", MoshiUtils.toJson(result.data))
                }

                is HttpResult.Failure -> {
                    Log.e("Failure", result.message + "  -----  " + result.code)
                }

            }
        }
    }

}