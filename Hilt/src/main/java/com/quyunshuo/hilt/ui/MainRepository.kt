package com.quyunshuo.hilt.ui

import android.util.Log
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

/**
 * @Author: QuYunShuo
 * @Time: 2020/8/12
 * @Class: MainRepository
 * @Remark:
 */
@ActivityScoped
class MainRepository @Inject constructor() {

    fun test() {
        Log.d("qqq", "MainRepository")
    }
}