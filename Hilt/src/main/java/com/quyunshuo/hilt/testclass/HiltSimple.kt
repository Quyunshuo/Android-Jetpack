package com.quyunshuo.hilt.testclass

import android.util.Log
import javax.inject.Inject

// 在构造方法上使用@Inject
class HiltSimple @Inject constructor() {

    fun doSomething() {
        Log.d("qqq", "doSomething: ")
    }
}