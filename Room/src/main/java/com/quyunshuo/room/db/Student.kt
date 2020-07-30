package com.quyunshuo.room.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @Author: QuYunShuo
 * @Time: 2020/7/30
 * @Class:Student
 * @Remark: Room 学生表
 */
@Entity(tableName = "student")
data class Student(
    @ColumnInfo(name = "name", typeAffinity = ColumnInfo.TEXT) var name: String,
    @ColumnInfo(name = "age", typeAffinity = ColumnInfo.TEXT) var age: String,
    @PrimaryKey(autoGenerate = true) val id: Int = 0
)

/**
 * @Entity 注解用于将该类与Room中的数据表对应起来，tableName 属性可以设置数据表的表名，若不设置，则表名与类名相同
 * @PrimaryKey 注解用于指定该字段作为表的主键
 * @ColumnInfo 注解用于设置该字段存储在数据库表中的名字，并指定其类型
 * @Ignore 注解用于告诉Room忽略该字段或方法
 */