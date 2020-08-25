package com.quyunshuo.hilt.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.quyunshuo.hilt.testclass.NetDataSource
import com.quyunshuo.hilt.R
import com.quyunshuo.hilt.databinding.ActivityMainBinding
import com.quyunshuo.hilt.testclass.HiltSimple
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.MainScope
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

    @Inject
    lateinit var mHiltSimple: HiltSimple

    private val mViewModel by viewModels<MainViewModel>()

    private val mBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mNetDataSource.test()
        mViewModel.test()
        mHiltSimple.doSomething()
        supportFragmentManager
            .beginTransaction()
            .add(R.id.mContainer, HiltFragment::class.java, null)
            .commit()
    }
}
