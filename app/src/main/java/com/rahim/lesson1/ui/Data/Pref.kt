package com.rahim.lesson1.ui.Data

import android.content.Context
import android.content.Context.MODE_PRIVATE

class Pref (private val context: Context) {

    private val pref = context.getSharedPreferences(PREF_NAME,MODE_PRIVATE)



     fun isUserSeen(): Boolean{
        return pref.getBoolean(SEEN_KEY, false)
    }

    fun userSeen(){
      pref.edit().putBoolean(SEEN_KEY,true).apply()
    }

    fun saveName(name: String){
        pref.edit().putString(NAME,name).apply()
    }

    fun getName():String{
        return pref.getString(GET_NAME, "").toString()
    }

    fun saveAge(age: String){
        pref.edit().putString(SAVE_AGE,age).apply()
    }
    fun getAge():String{
        return pref.getString(GET_AGE,"0").toString()
    }

    fun saveImage(image: String){
        pref.edit().putString(SAVE_IMAGE,image).apply()
    }

 fun getImage():String{
     return pref.getString(GET_IMAGE,"").toString()
 }








    companion object{
        const val PREF_NAME = "pref_name"
        const val SEEN_KEY = "SEEN_KEY"
        const val NAME = "NAME"
        const val GET_NAME = "GET_NAME"
        const val SAVE_AGE =" SAVE_AGE"
        const val GET_AGE = "AGE_SAVE"
        const val SAVE_IMAGE = "IMAGE"
        const val GET_IMAGE = "IMAGE_GET"
    }

}