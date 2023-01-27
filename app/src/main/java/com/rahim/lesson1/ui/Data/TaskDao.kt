package com.rahim.lesson1.ui.Data

import androidx.room.*
import com.rahim.lesson1.ui.Task.TaskData
import com.rahim.lesson1.ui.home.HomeFragment

@Dao
interface TaskDao {
  @Query("SELECT * FROM user")
  fun getAll(): List <TaskData>

  @Insert
  fun insert(taskData: TaskData)

  @Delete
  fun delete(taskData: Unit)

  @Update
  fun update(taskData: TaskData)


}