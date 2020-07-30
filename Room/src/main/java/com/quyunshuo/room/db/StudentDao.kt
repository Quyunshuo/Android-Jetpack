package com.quyunshuo.room.db

import androidx.room.*

/**
 * @Author: QuYunShuo
 * @Time: 2020/7/30
 * @Class: StudentDao
 * @Remark: 学生表的 Dao 数据访问对象
 */
@Dao
interface StudentDao {

    @Insert
    fun insertStudent(student: Student)

    @Delete
    fun deleteStudent(student: Student)

    @Update
    fun updateStudent(student: Student)

    @Query("SELECT * FROM student")
    fun getStudentList(): List<Student>

    /**
     * 应该声明为可空类型 kotlin无法预知其Java实现的返回 无此条数据的时候会返回null
     */
    @Query("SELECT * FROM student WHERE id = :id")
    fun getStudentById(id: Int): Student?
}