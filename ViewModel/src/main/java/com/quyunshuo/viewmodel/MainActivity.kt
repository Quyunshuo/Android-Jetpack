package com.quyunshuo.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.quyunshuo.viewmodel.databinding.ActivityMainBinding

/**
 * @Author: QuYunShuo
 * @Time:   2020/7/26
 * @Class:  MainActivity
 * @Remark:
 */
class MainActivity : AppCompatActivity() {

    private val mBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private val mViewModel by lazy { ViewModelProvider(this).get(MainViewModel::class.java) }

    private val mAndroidViewModel by lazy {
        ViewModelProvider.AndroidViewModelFactory.getInstance(application)
            .create(MainAndroidViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mBinding.root)
        initView()
        mAndroidViewModel.showToast("AndroidViewModel")
    }

    private fun initView() {
        // 当屏幕旋转 Activity 重建时 计时的数据不会重置
        mViewModel.setTimeChangeCallback {
            runOnUiThread { mBinding.mTimeTv.text = mViewModel.mCurrentSecond.toString() }
        }
        if (mViewModel.mCurrentSecond == 0) {
            mViewModel.startTiming()
        }
    }
}
