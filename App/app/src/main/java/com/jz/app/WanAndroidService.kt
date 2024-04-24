package com.jz.app

import com.jz.lib_common.network.RetrofitApi
import com.jz.lib_common.network.core.MoshiResultTypeAdapterFactory
import okhttp3.Interceptor

object WanAndroidService : RetrofitApi("https://www.wanandroid.com/") {

    override fun getInterceptor(): Interceptor? {
        return Interceptor { chain ->
            val builder = chain.request().newBuilder()
            builder.addHeader("Source", "source")
            chain.proceed(builder.build())
        }
    }

    /**
     * 获取WannaAndroidApi 服务
     */
    fun getService():WanAndroidApi{

        return createRxJava(WanAndroidApi::class.java)
    }



    /**
     * 把服务器返回的JSON 通用的大体结构字段定义出来，方便解析
     *
    "status": "OK",
    "code": 200,
    "total": 15,
    "data": [
     *
     */
    override fun getHttpWrapperHandler(): MoshiResultTypeAdapterFactory.HttpWrapper{

        return object : MoshiResultTypeAdapterFactory.HttpWrapper {
            override fun getStatusCodeKey(): String {
                return "errorCode"
            }

            override fun getErrorMsgKey(): String {
                return "errorMsg"
            }

            override fun getDataKey(): String {
                return "data"
            }

            /**
             * 业务上是正确返回了数据
             */

            override fun isRequestSuccess(statusCode: Int): Boolean {
                return statusCode == 1
            }
        }
    }

}