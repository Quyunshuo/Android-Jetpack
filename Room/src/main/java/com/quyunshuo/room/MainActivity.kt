package com.quyunshuo.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.quyunshuo.room.databinding.ActivityMainBinding
import com.quyunshuo.room.db.MyDatabase
import com.quyunshuo.room.db.Student
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * @Author: QuYunShuo
 * @Time: 2020/7/30
 * @Class:MainActivity
 * @Remark:
 */
class MainActivity : AppCompatActivity() {

    private val mBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private val mMainScope by lazy { MainScope() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mBinding.root)
        operateDB()
    }

    private fun operateDB() {
        val studentDao = MyDatabase.instance.getStudentDao()
        mBinding.mInsertBtn.setOnClickListener {
            mMainScope.launch(Dispatchers.IO) {
                studentDao.insertStudent(Student("屈云硕", "22"))
                studentDao.insertStudent(Student("李品", "20"))
            }
        }
        mBinding.mDeleteBtn.setOnClickListener {
            mMainScope.launch(Dispatchers.IO) {
                val studentList = studentDao.getStudentList()
                if (studentList.isNotEmpty()) studentDao.deleteStudent(studentList[studentList.size - 1])
            }
        }
        mBinding.mUpdateBtn.setOnClickListener {
            mMainScope.launch(Dispatchers.IO) {
                studentDao.getStudentById(0)?.let {
                    studentDao.updateStudent(it.apply { age = "18" })
                }
            }
        }
        mBinding.mQueryAllBtn.setOnClickListener {
            mMainScope.launch(Dispatchers.IO) {
                val studentList = studentDao.getStudentList()
                withContext(Dispatchers.Main) {
                    mBinding.mMsgInfoTv.text = studentList.toString()
                }
            }
        }
    }
}
