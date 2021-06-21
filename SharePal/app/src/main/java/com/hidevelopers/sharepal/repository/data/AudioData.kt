package com.hidevelopers.sharepal.repository.data

import android.net.Uri
import com.hidevelopers.sharepal.repository.data.MediaData

data class AudioData(
        override val uri: Uri,
        override val idIndex:Long,//   songCursor.getColumnIndex(MediaStore.Audio.Media._ID);
        override val dateIndex:String="",//songCursor.getColumnIndex(MediaStore.Audio.Media.DATE_MODIFIED
        override val sizeIndex:Long,//songCursor.getColumnIndex(MediaStore.Audio.Media.SIZE);
        override val typeIndex:String="",//songCursor.getColumnIndex(MediaStore.Audio.Media.MIME_TYPE);
        override val folderIndex:String="",// songCursor.getColumnIndex(MediaStore.Audio.Media.DATA);
        val artistIndex:String,// songCursor.getColumnIndex(MediaStore.Audio.Media.ARTIST);
        val songIndex:String,//   songCursor.getColumnIndex(MediaStore.Audio.Media.TITLE)
        val albumIndex:String,// songCursor.getColumnIndex(MediaStore.Audio.Media.ALBUM_ID);
        val nameIndex:String,//songCursor.getColumnIndex(MediaStore.Audio.Media.DISPLAY_NAME)
): MediaData
