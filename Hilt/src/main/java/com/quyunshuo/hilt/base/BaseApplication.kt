package com.quyunshuo.hilt.base

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * @Author: QuYunShuo
 * @Time: 2020/8/12
 * @Class: BaseApplication
 * @Remark:
 *
 * 所有使用 Hilt 的应用都必须包含一个带有 @HiltAndroidApp 注释的 Application 类
 * @HiltAndroidApp 会触发 Hilt 的代码生成操作，生成的代码包括应用的一个基类，该基类充当应用级依赖项容器
 * 生成的这一 Hilt 组件会附加到 Application 对象的生命周期，并为其提供依赖项
 * 此外，它也是应用的父组件，这意味着，其他组件可以访问它提供的依赖项
 */
@HiltAndroidApp
class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}