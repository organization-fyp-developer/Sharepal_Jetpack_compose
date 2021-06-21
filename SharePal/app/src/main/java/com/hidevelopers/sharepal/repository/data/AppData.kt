package com.hhdeveloper.sharingapplication.datasource.data

import android.graphics.drawable.Drawable

data class AppData(
    val appPackageName:String,
    val appName:String,
    val appIcon:Drawable?,
    val sizeIndex:String
)