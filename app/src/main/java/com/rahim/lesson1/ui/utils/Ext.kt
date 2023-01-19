package com.rahim.lesson1.ui.utils

import android.widget.ImageView
import com.bumptech.glide.Glide

fun  ImageView.loadIMage(image: String){
    Glide.with(this).load(image).into(this)
}