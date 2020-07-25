package com.quyunshuo.navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.quyunshuo.navigation.databinding.ActivityMainBinding

/**
 * @Author: QuYunShuo
 * @Time:   2020/7/25
 * @Class:  MainActivity
 * @Remark:
 */
class MainActivity : AppCompatActivity() {

    private val mBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mBinding.root)
    }
}
