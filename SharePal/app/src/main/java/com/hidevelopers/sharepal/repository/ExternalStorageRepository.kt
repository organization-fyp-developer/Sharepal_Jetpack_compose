package com.hidevelopers.sharepal.repository

import com.hidevelopers.sharepal.repository.data.AppData
import com.hidevelopers.sharepal.repository.data.AudioData
import com.hidevelopers.sharepal.repository.data.ImageData
import com.hidevelopers.sharepal.repository.data.VideoData

interface ExternalStorageRepository {
    suspend fun getVideosList():List<VideoData>
    suspend fun getAudiosList():List<AudioData>
    suspend fun getImagesList():List<ImageData>
    suspend fun getDocumentData()
    suspend fun getInstallApp():List<AppData>
}