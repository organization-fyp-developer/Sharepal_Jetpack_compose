package com.hidevelopers.sharepal.utils


fun timeConversion(value: Long): String {
    val videoTime: String
    val dur = value.toInt()
    val hrs = dur / 3600000
    val mns = dur / 60000 % 60000
    val scs = dur % 60000 / 1000
    videoTime = if (hrs > 0) {
        String.format("%02d:%02d:%02d", hrs, mns, scs) + " hr"
    } else {
        String.format("%02d:%02d", mns, scs) + " mint."
    }
    return videoTime
}
