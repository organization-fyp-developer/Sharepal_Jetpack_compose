package com.hidevelopers.sharepal.repository

interface ExternalStorageRepository {
    suspend fun getMediaData()
    suspend fun getDocumentData()
}