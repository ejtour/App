package com.jz.app

import com.jz.lib_common.network.RetrofitApi
import okhttp3.Interceptor

object EuropApiService : RetrofitApi("https://api.europeana.eu/record/v2/") {
    override fun getInterceptor(): Interceptor? {
        return null
    }

    /**
     * 减少一点重复代码
     *
     */
    fun getService(): WanAndroidApi {

        return createRxJava(WanAndroidApi::class.java)
    }

}