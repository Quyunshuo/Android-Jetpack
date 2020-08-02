package com.quyunshuo.room.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.quyunshuo.room.databinding.ActivityMainBinding
import com.quyunshuo.room.db.Student
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

/**
 * @Author: QuYunShuo
 * @Time: 2020/7/30
 * @Class:MainActivity
 * @Remark:
 */
class MainActivity : AppCompatActivity() {

    private val mBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private val mViewModel by lazy { ViewModelProvider(this).get(MainViewModel::class.java) }

    private val mMainScope by lazy { MainScope() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mBinding.root)
        operateDB()
    }

    private fun operateDB() {
        mViewModel.getStudentLiveData()
            .observe(this, Observer { mBinding.mMsgInfoTv.text = it.toString() })

        // 插入数据
        mBinding.mInsertBtn.setOnClickListener {
            mViewModel.insertStudentData(Student("小品品", "18"))
        }

        // 删除一条学生数据
        mBinding.mDeleteBtn.setOnClickListener {
            mViewModel.deleteStudent()
        }

        // 更新一条学生数据
        mBinding.mUpdateBtn.setOnClickListener {
            mViewModel.updateStudent()
        }

        // 查询全部学生数据
        mBinding.mQueryAllBtn.setOnClickListener {
            mMainScope.launch(Dispatchers.IO) { mViewModel.queryStudentAll() }
        }
    }
}
