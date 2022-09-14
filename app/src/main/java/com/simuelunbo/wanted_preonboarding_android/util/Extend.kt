package com.simuelunbo.wanted_preonboarding_android.util

import java.text.SimpleDateFormat
import java.util.*

private object MAXIMUM {
    const val SEC = 60
    const val MIN = 60
    const val HOUR = 24
    const val DAY = 30
    const val MONTH = 12
}

fun String?.toTimeElapsed(): String {
    val regTime = if (this == null) {
        Date().time
    } else {
        SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.KOREA).parse(this)?.time ?: Date().time
    }
    val curTime = System.currentTimeMillis()
    var diffTime = (curTime - regTime) / 1000

    return when {
        diffTime < MAXIMUM.SEC -> "a $diffTime ago"
        MAXIMUM.SEC.let { diffTime /= it; diffTime } < MAXIMUM.MIN -> "$diffTime minutes ago"
        MAXIMUM.MIN.let { diffTime /= it; diffTime } < MAXIMUM.HOUR -> "$diffTime hours ago"
        MAXIMUM.HOUR.let { diffTime /= it; diffTime } < MAXIMUM.DAY -> "$diffTime days ago"
        MAXIMUM.DAY.let { diffTime /= it; diffTime } < MAXIMUM.MONTH -> "$diffTime months ago"
        else -> ""
    }
}