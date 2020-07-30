package com.quyunshuo.room

import android.app.Application
import android.content.Context

/**
 * @Author: QuYunShuo
 * @Time: 2020/7/30
 * @Class:BaseApplication
 * @Remark:
 */
class BaseApplication : Application() {

    companion object {
        lateinit var mContext: Context
        lateinit var mApplication: Application
    }

    override fun onCreate() {
        super.onCreate()
        mApplication = this
        mContext = mApplication.applicationContext
    }
}