package com.quyunshuo.hilt.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.quyunshuo.hilt.db.NetDataSource
import com.quyunshuo.hilt.R
import com.quyunshuo.hilt.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * @Author: QuYunShuo
 * @Time: 2020/8/12
 * @Class: MainActivity
 * @Remark:
 */
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var mNetDataSource: NetDataSource

    private val mViewModel by viewModels<MainViewModel>()

    private val mBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mNetDataSource.test()
        mViewModel.test()
    }
}
