package com.quyunshuo.room.db

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.quyunshuo.room.base.BaseApplication

/**
 * @Author: QuYunShuo
 * @Time: 2020/7/30
 * @Class: MyDatabase
 * @Remark: 数据库类
 */
@Database(entities = [Student::class], version = 1)
abstract class MyDatabase : RoomDatabase() {

    companion object {
        // 双重校验锁单例 lazy 内部实现
        val instance: MyDatabase by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            Room.databaseBuilder(BaseApplication.mContext, MyDatabase::class.java, "my_db").build()
        }
    }

    abstract fun getStudentDao(): StudentDao
}