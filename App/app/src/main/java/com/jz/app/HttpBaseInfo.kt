package com.jz.app

import android.app.Application
import com.jz.lib_common.network.NetInfo

class HttpBaseInfo : NetInfo {
    override fun showLog(): Boolean {
        return true
    }

    override fun getAppVersionName(): String? {

        return "1.0.1"
    }

    override fun getAppVersionCode(): String? {
        return "1"
    }

    override fun getApplicationContext(): Application? {

        return null
    }
}