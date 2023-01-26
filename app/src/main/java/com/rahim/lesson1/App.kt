package com.rahim.lesson1

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.rahim.lesson1.ui.Data.AppDatabase

class App: Application() {


    override fun onCreate() {
        super.onCreate()

         db = Room.databaseBuilder(applicationContext, AppDatabase::class.java,"database-name").allowMainThreadQueries().build()
    }

    companion object {
    lateinit var db: AppDatabase

    }
}