package com.hidevelopers.sharepal.repository


import android.content.ContentUris
import android.content.Context
import android.content.Intent
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.content.pm.ResolveInfo
import android.graphics.drawable.Drawable
import android.provider.MediaStore
import androidx.core.content.ContextCompat
import com.hhdeveloper.sharingapplication.datasource.data.AppData
import com.hidevelopers.sharepal.R
import com.hidevelopers.sharepal.repository.data.AudioData
import com.hidevelopers.sharepal.repository.data.ImageData
import com.hidevelopers.sharepal.repository.data.VideoData
import com.hidevelopers.sharepal.utils.getMediaList
import com.hidevelopers.sharepal.utils.sdk29AndUp
import com.hidevelopers.sharepal.utils.timeConversion
import java.io.File
import java.lang.Exception
import javax.inject.Inject


class StorageRepo : ExternalStorageRepository {

    @Inject
    lateinit var context: Context

    override suspend fun getVideosList(): List<VideoData> {
        val collection = sdk29AndUp {
            MediaStore.Video.Media.getContentUri(MediaStore.VOLUME_EXTERNAL)
        } ?: MediaStore.Video.Media.EXTERNAL_CONTENT_URI
        val projection = arrayOf(
            MediaStore.Video.Media._ID,
            MediaStore.Video.Media.TITLE,
            MediaStore.Video.Media.DISPLAY_NAME,
            MediaStore.Video.Media.BUCKET_DISPLAY_NAME,
            MediaStore.Video.Media.DURATION,
            MediaStore.Video.Media.DATE_MODIFIED,
            MediaStore.Video.Media.SIZE,
            MediaStore.Video.Media.MIME_TYPE
        )
        val sortOrder = "${MediaStore.Video.Media.BUCKET_DISPLAY_NAME} ASC"
        return getMediaList(
            context = context,
            mediaUri = collection,
            projection = projection,
            selection = null,
            selectArg = null,
            sortOrder = sortOrder
        ) {
            val idIndex = it.getLong(it.getColumnIndexOrThrow(MediaStore.Video.Media._ID))
            val titleIndex = it.getString(it.getColumnIndexOrThrow(MediaStore.Video.Media.TITLE))
            val displayIndex =
                it.getString(it.getColumnIndexOrThrow(MediaStore.Video.Media.DISPLAY_NAME))
            val albumIndex =
                it.getString(it.getColumnIndexOrThrow(MediaStore.Video.Media.BUCKET_DISPLAY_NAME))
            val lengthIndex =
                it.getString(it.getColumnIndexOrThrow(MediaStore.Video.Media.DURATION))
            val dateIndex =
                it.getLong(it.getColumnIndexOrThrow(MediaStore.Video.Media.DATE_MODIFIED))
            val sizeIndex = it.getLong(it.getColumnIndexOrThrow(MediaStore.Video.Media.SIZE))
            val typeIndex = it.getString(it.getColumnIndexOrThrow(MediaStore.Video.Media.MIME_TYPE))
            val uri = ContentUris.withAppendedId(
                MediaStore.Video.Media.EXTERNAL_CONTENT_URI,
                idIndex
            )
            VideoData(
                uri = uri,
                idIndex = idIndex,
                titleIndex = titleIndex.toString(),
                displayIndex = displayIndex.toString(),
                folderIndex = albumIndex.toString(),
                lengthIndex = lengthIndex.toString(),
                dateIndex = timeConversion(dateIndex),
                sizeIndex = sizeIndex,
                typeIndex = typeIndex.toString()
            )
        }
    }

    override suspend fun getAudiosList(): List<AudioData> {
        val collection = sdk29AndUp {
            MediaStore.Audio.Media.getContentUri(MediaStore.VOLUME_EXTERNAL)
        } ?: MediaStore.Audio.Media.EXTERNAL_CONTENT_URI

        val projection = arrayOf(
            MediaStore.Audio.Media._ID,
            MediaStore.Audio.Media.ARTIST,
            MediaStore.Audio.Media.TITLE,
            MediaStore.Audio.Media.BUCKET_DISPLAY_NAME,
            MediaStore.Audio.Media.ALBUM_ID,
            MediaStore.Audio.Media.DISPLAY_NAME,
            MediaStore.Audio.Media.DATE_MODIFIED,
            MediaStore.Audio.Media.SIZE,
            MediaStore.Audio.Media.MIME_TYPE
        )
        val sortOrder = "${MediaStore.Audio.Media.BUCKET_DISPLAY_NAME} ASC"
        return getMediaList(
            context = context,
            mediaUri = collection,
            projection = projection,
            selection = null,
            selectArg = null,
            sortOrder = sortOrder
        ) {
            val idIndex = it.getLong(it.getColumnIndexOrThrow(MediaStore.Audio.Media._ID))
            val artistIndex = it.getString(it.getColumnIndexOrThrow(MediaStore.Audio.Media.ARTIST))
            val songIndex = it.getString(it.getColumnIndexOrThrow(MediaStore.Audio.Media.TITLE))
            val folderIndex =
                it.getString(it.getColumnIndexOrThrow(MediaStore.Audio.Media.BUCKET_DISPLAY_NAME))
            val albumIndex = it.getString(it.getColumnIndexOrThrow(MediaStore.Audio.Media.ALBUM_ID))
            val nameIndex =
                it.getString(it.getColumnIndexOrThrow(MediaStore.Audio.Media.DISPLAY_NAME))
            val dateIndex =
                it.getLong(it.getColumnIndexOrThrow(MediaStore.Audio.Media.DATE_MODIFIED))
            val sizeIndex = it.getLong(it.getColumnIndexOrThrow(MediaStore.Audio.Media.SIZE))
            val typeIndex = it.getString(it.getColumnIndexOrThrow(MediaStore.Audio.Media.MIME_TYPE))
            val uri = ContentUris.withAppendedId(
                MediaStore.Video.Media.EXTERNAL_CONTENT_URI,
                idIndex
            )
            AudioData(
                uri = uri,
                idIndex = idIndex,
                artistIndex = artistIndex.toString(),
                songIndex = songIndex.toString(),
                folderIndex = folderIndex.toString(),
                albumIndex = albumIndex.toString(),
                nameIndex = nameIndex.toString(),
                dateIndex = timeConversion(dateIndex),
                sizeIndex = sizeIndex,
                typeIndex = typeIndex.toString()
            )
        }
    }

    override suspend fun getImagesList(): List<ImageData> {
        val collection = sdk29AndUp {
            MediaStore.Images.Media.getContentUri(MediaStore.VOLUME_EXTERNAL)
        } ?: MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        val projection = arrayOf(
            MediaStore.Images.Media._ID,
            MediaStore.Images.Media.TITLE,
            MediaStore.Images.Media.DISPLAY_NAME,
            MediaStore.Images.Media.BUCKET_DISPLAY_NAME,
            MediaStore.Images.Media.DATE_MODIFIED,
            MediaStore.Images.Media.SIZE,
            MediaStore.Images.Media.MIME_TYPE
        )
        val sortOrder = "${MediaStore.Images.Media.BUCKET_DISPLAY_NAME} ASC "
        return getMediaList(
            context = context,
            mediaUri = collection,
            projection = projection,
            selection = null,
            selectArg = null,
            sortOrder = sortOrder,
        ) {
            val idIndex = it.getLong(it.getColumnIndexOrThrow(MediaStore.Images.Media._ID))
            val titleIndex = it.getString(it.getColumnIndexOrThrow(MediaStore.Images.Media.TITLE))
            val displayIndex =
                it.getString(it.getColumnIndexOrThrow(MediaStore.Images.Media.DISPLAY_NAME))
            val albumIndex =
                it.getString(it.getColumnIndexOrThrow(MediaStore.Images.Media.BUCKET_DISPLAY_NAME))
            val dateIndex =
                it.getLong(it.getColumnIndexOrThrow(MediaStore.Images.Media.DATE_MODIFIED))
            val sizeIndex = it.getLong(it.getColumnIndexOrThrow(MediaStore.Images.Media.SIZE))
            val typeIndex =
                it.getString(it.getColumnIndexOrThrow(MediaStore.Images.Media.MIME_TYPE))
            val uri = ContentUris.withAppendedId(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                idIndex
            )
            ImageData(
                uri = uri,
                idIndex = idIndex,
                titleIndex = titleIndex,
                displayIndex = displayIndex,
                folderIndex = albumIndex,
                dateIndex = timeConversion(dateIndex),
                sizeIndex = sizeIndex,
                typeIndex = typeIndex
            )
        }
    }

    override suspend fun getDocumentData() {
        TODO("Not yet implemented")
    }


    override suspend fun getInstallApp(): List<AppData> {
        val appListSize = mutableListOf<AppData>()
        val apkPackageName = getInstallApps()
        for (item in apkPackageName) {
            appListSize.add(
                AppData(
                    appPackageName = item,
                    appName = getAppName(item),
                    appIcon = getAppIconByPackageName(item),
                    sizeIndex = getAppSize(item)
                )
            )
        }
        return appListSize
    }

    private fun getInstallApps(): List<String> {
        val apkPackageName = arrayListOf<String>()
        val intent = Intent(Intent.ACTION_MAIN, null)
        intent.addCategory(Intent.CATEGORY_LAUNCHER)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED
        val resolveInfoList: List<ResolveInfo> =
            context.packageManager!!.queryIntentActivities(intent, 0)
        for (resolveInfo in resolveInfoList) {
            val activityInfo = resolveInfo.activityInfo
            if (!isSystemPackage(resolveInfo)) {
                apkPackageName.add(activityInfo.applicationInfo.packageName)
            }
        }
        return apkPackageName
    }

    private fun isSystemPackage(resolveInfo: ResolveInfo): Boolean {
        return resolveInfo.activityInfo.applicationInfo.flags and ApplicationInfo.FLAG_SYSTEM != 0
    }

    private fun getAppIconByPackageName(apkTempPackageName: String): Drawable? {
        return try {
            context.packageManager.getApplicationIcon(apkTempPackageName)
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
            ContextCompat.getDrawable(
                context,
                R.mipmap.ic_launcher
            )
        }
    }

    private fun getAppName(ApkPackageName: String?): String {
        var name = ""
        val applicationInfo: ApplicationInfo
        val packageManager: PackageManager = context.packageManager
        try {
            applicationInfo = packageManager.getApplicationInfo(ApkPackageName!!, 0)
            name = packageManager.getApplicationLabel(applicationInfo) as String
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }
        return name
    }

    private fun getAppSize(apkPackageName: String): String {
        var size = 0L
        try {
            size = File(
                context.packageManager.getApplicationInfo(
                    apkPackageName, 0
                ).publicSourceDir
            ).length()
        } catch (ex: Exception) {
        }
        return size.toString()
    }
}
