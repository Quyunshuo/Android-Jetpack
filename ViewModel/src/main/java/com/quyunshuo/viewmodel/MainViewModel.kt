package com.quyunshuo.viewmodel

import androidx.lifecycle.ViewModel
import java.util.*

/**
 * @Author: QuYunShuo
 * @Time:   2020/7/26
 * @Class:  MainViewModel
 * @Remark:
 */
class MainViewModel : ViewModel() {

    private val mTimer by lazy { Timer() }

    var mCurrentSecond = 0

    private var mTimeChangeCallback: (() -> Unit)? = null

    /**
     * 开始计数
     */
    fun startTiming() {
        mTimer.schedule(object : TimerTask() {
            override fun run() {
                mCurrentSecond++
                mTimeChangeCallback?.invoke()
            }
        }, 1000, 1000)
    }

    fun setTimeChangeCallback(callback: () -> Unit) {
        this.mTimeChangeCallback = callback
    }

    override fun onCleared() {
        super.onCleared()
        mTimer.cancel()
    }
}