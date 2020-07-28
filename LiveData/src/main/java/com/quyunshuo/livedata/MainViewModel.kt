package com.quyunshuo.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

/**
 * @Author: QuYunShuo
 * @Time: 2020/7/28
 * @Class:MainViewModel
 * @Remark:
 */
class MainViewModel : ViewModel() {

    private val mTimer by lazy { Timer() }

    private var mCurrentSecond: MutableLiveData<Int> = MutableLiveData()

    fun getCurrentSecond(): LiveData<Int> = mCurrentSecond

    /**
     * 开始计数
     */
    fun startTiming() {
        mCurrentSecond.value = 0
        mTimer.schedule(object : TimerTask() {
            override fun run() {
                mCurrentSecond.postValue(mCurrentSecond.value!! + 1)
            }
        }, 1000, 1000)
    }

    override fun onCleared() {
        super.onCleared()
        mTimer.cancel()
    }
}