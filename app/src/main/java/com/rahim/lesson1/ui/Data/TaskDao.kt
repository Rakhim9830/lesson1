package com.rahim.lesson1.ui.Data

import androidx.room.*
import com.rahim.lesson1.ui.Task.TaskData

@Dao
interface TaskDao {
  @Query("SELECT * FROM user")
  fun getAll(): List <TaskData>

  @Insert
  fun insert(taskData: TaskData)

  @Delete
  fun delete(): List<TaskData>

  @Update
  fun update(taskData: TaskData)


}