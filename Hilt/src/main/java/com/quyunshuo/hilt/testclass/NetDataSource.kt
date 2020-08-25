package com.quyunshuo.hilt.testclass

import android.util.Log
import javax.inject.Inject

class NetDataSource @Inject constructor() {
    fun test() {
        Log.d("qqq", "我是NetDataSource测试类")
    }
}