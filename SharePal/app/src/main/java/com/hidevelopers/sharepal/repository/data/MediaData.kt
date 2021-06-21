package com.hidevelopers.sharepal.repository.data

import android.net.Uri

interface MediaData {
    val uri: Uri
    val idIndex: Long
    val folderIndex: String
    val dateIndex: String
    val sizeIndex: Long
    val typeIndex: String
}