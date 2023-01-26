package com.rahim.lesson1.ui.Task

import androidx.room.Entity
import androidx.room.PrimaryKey


import java.io.Serializable
@Entity
data  class TaskData (
    @PrimaryKey(autoGenerate = true)
    var id:Int? = null,
     var title:String? = null,
     var desc:String? = null

) : Serializable

