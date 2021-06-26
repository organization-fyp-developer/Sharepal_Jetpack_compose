package com.hidevelopers.sharepal.utils

import android.app.Application
import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.os.Build
import com.hidevelopers.sharepal.repository.data.MediaData

inline fun <T> sdk29AndUp(onSdk29: () -> T): T?{
    return if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q){
        onSdk29()
    }else null
}

inline fun <T:MediaData> getMediaList (
    context: Application,
    mediaUri: Uri,
    projection: Array<String>,
    selection: String?,
    selectArg: Array<String>?,
    sortOrder: String?,
    action: (cursor: Cursor) -> T
):List<T>{
    val saveMediaList = mutableListOf<T>()
    val cursor = context.contentResolver.query(
        mediaUri,
        projection,
        selection,
        selectArg,
        sortOrder
    )
    try {
        cursor?.use{it ->
            while (it.moveToNext()){
                saveMediaList.add(action(it))
            }
        }
    }catch (ex: Exception){

    }
    cursor?.let {
        if(!it.isClosed){
            it.close()
        }
    }
    return saveMediaList
}