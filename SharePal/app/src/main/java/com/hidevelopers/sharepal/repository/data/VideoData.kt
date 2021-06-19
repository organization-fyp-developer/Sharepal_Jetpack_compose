package com.hidevelopers.sharepal.repository.data

import android.net.Uri

data class VideoData(
        override val uri: Uri,
        override val idIndex:Long,//cursor.getColumnIndex(MediaStore.Video.Media._ID);
        val titleIndex:String,//cursor.getColumnIndex(MediaStore.Video.Media.TITLE);
        val displayIndex:String,//cursor.getColumnIndex(MediaStore.Video.Media.DISPLAY_NAME);
        override val folderIndex:String,//cursor.getColumnIndex(MediaStore.Video.Media.BUCKET_DISPLAY_NAME);
        val lengthIndex:String,// cursor.getColumnIndex(MediaStore.Video.Media.DURATION);
        override val dateIndex:String, //cursor.getColumnIndex(MediaStore.Video.Media.DATE_MODIFIED
        override val sizeIndex:Long, //cursor.getColumnIndex(MediaStore.Video.Media.SIZE);
        override val typeIndex:String //cursor.getColumnIndex(MediaStore.Video.Media.MIME_TYPE);
): MediaData
