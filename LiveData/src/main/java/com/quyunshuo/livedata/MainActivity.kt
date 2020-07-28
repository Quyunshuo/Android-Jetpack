package com.quyunshuo.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.quyunshuo.livedata.databinding.ActivityMainBinding

/**
 * @Author: QuYunShuo
 * @Time: 2020/7/28
 * @Class: MainActivity
 * @Remark:
 */
class MainActivity : AppCompatActivity() {

    private val mBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private val mViewModel by lazy { ViewModelProvider(this).get(MainViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mBinding.root)
        val currentSecond = mViewModel.getCurrentSecond()
        currentSecond.observe(
            this,
            Observer { mBinding.tv.text = (currentSecond.value ?: 0).toString() })
        if (currentSecond.value == null || currentSecond.value == 0) {
            mViewModel.startTiming()
        }
    }
}
