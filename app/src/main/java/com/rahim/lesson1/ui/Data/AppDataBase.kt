package com.rahim.lesson1.ui.Data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rahim.lesson1.ui.Task.TaskData

@Database(entities = [TaskData::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}