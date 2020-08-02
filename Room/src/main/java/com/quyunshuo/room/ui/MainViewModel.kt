package com.quyunshuo.room.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.quyunshuo.room.db.MyDatabase
import com.quyunshuo.room.db.Student
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * @Author: QuYunShuo
 * @Time:   2020/8/2
 * @Class: MainViewModel
 * @Remark:
 */
class MainViewModel : ViewModel() {

    private val mStudentDAO by lazy { MyDatabase.instance.getStudentDao() }

    private var mStudentLiveData = MutableLiveData<List<Student>>()

    fun getStudentLiveData(): LiveData<List<Student>> {
        return mStudentLiveData
    }

    /**
     * 插入数据
     */
    fun insertStudentData(student: Student) {
        viewModelScope.launch(Dispatchers.IO) {
            mStudentDAO.insertStudent(student)
            queryStudentAll()
        }
    }

    /**
     * 删除一条数据
     */
    fun deleteStudent() {
        viewModelScope.launch(Dispatchers.IO) {
            val studentList = mStudentDAO.getStudentList()
            if (studentList.isNotEmpty())
                mStudentDAO.deleteStudent(studentList[0])
            queryStudentAll()
        }
    }

    /**
     * 更新一条数据
     */
    fun updateStudent() {
        viewModelScope.launch(Dispatchers.IO) {
            val studentList = mStudentDAO.getStudentList()
            if (studentList.isNotEmpty()) {
                studentList[0].apply {
                    name = "大品品"
                    mStudentDAO.updateStudent(this)
                }
                queryStudentAll()
            }
        }
    }

    /**
     * 查询全部学生数据
     * 未做线程处理
     */
    suspend fun queryStudentAll() = withContext(Dispatchers.IO) {
        mStudentLiveData.postValue(mStudentDAO.getStudentList())
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
}