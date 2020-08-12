package com.quyunshuo.hilt.ui

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

/**
 * @Author: QuYunShuo
 * @Time: 2020/8/12
 * @Class: MainViewModel
 * @Remark:
 */
class MainViewModel @ViewModelInject constructor(
    private val mRepository: MainRepository,
    @Assisted val savedState: SavedStateHandle
) :
    ViewModel() {
    fun test() {
        mRepository.test()
    }
}