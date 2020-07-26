package com.quyunshuo.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel

/**
 * @Author: QuYunShuo
 * @Time:   2020/7/26
 * @Class:  MainAndroidViewModel
 * @Remark: 继承自 AndroidViewModel 持有 Application 的上下文
 */
class MainAndroidViewModel(application: Application) : AndroidViewModel(application) {

    /**
     * 该方法只是为了测试
     */
    fun showToast(msg: String = "Toast") =
        Toast.makeText(getApplication(), msg, Toast.LENGTH_SHORT).show()
}