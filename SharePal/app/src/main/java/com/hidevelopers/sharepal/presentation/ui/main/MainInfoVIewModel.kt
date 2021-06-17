package com.hidevelopers.sharepal.presentation.ui.main

import android.os.Environment
import android.os.StatFs
import androidx.lifecycle.ViewModel
import java.text.DecimalFormat


class MainInfoVIewModel : ViewModel() {
    val stat = StatFs(Environment.getExternalStorageDirectory().absolutePath)
    fun totalMemory(): Long {
        val stat = StatFs(Environment.getExternalStorageDirectory().absolutePath)
        return (stat.blockCountLong * stat.blockSizeLong)
    }
    fun freeMemory(): Long {
        val stats = StatFs(Environment.getExternalStorageDirectory().absolutePath)
        return (stats.availableBlocksLong * stats.blockSizeLong)
    }
    fun floatForm(d: Double): String? {
        return DecimalFormat("#.##").format(d)
    }
    fun bytesToHuman(size: Long): String {
        val Kb = (1 * 1024).toLong()
        val Mb = Kb * 1024
        val Gb = Mb * 1024
        val Tb = Gb * 1024
        val Pb = Tb * 1024
        val Eb = Pb * 1024
        if (size < Kb) return floatForm(size.toDouble()).toString() + " byte"
        if (size in Kb until Mb) return floatForm(size.toDouble() / Kb).toString() + " Kb"
        if (size in Mb until Gb) return floatForm(size.toDouble() / Mb).toString() + " Mb"
        if (size in Gb until Tb) return floatForm(size.toDouble() / Gb).toString() + " Gb"
        if (size in Tb until Pb) return floatForm(size.toDouble() / Tb).toString() + " Tb"
        if (size in Pb until  Eb) return floatForm(size.toDouble() / Pb).toString() + " Pb"
        return if (size >= Eb) floatForm(size.toDouble() / Eb).toString() + " Eb" else "???"
    }
}