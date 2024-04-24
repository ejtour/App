package com.jz.app

import com.jz.lib_common.network.core.HttpResult
import com.jz.lib_common.network.NetInfo
import com.jz.lib_common.network.RetrofitApi
import retrofit2.http.GET

interface WanAndroidApi  {

    //测试直接写死参数 suspend
    @GET("banner/json")
    suspend fun getBanner(): HttpResult<List<BannerWithDefNPEField>>


    @GET("search.json?wskey=gogesqui&query=Paris&reusability=open&media=true")
    suspend fun getEuropData(): HttpResult<Any>

}