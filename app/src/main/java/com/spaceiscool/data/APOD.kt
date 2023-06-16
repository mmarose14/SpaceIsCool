package com.spaceiscool.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class APOD(
    val date: String,
    val explanation: String,
    val hdurl: String,
    val media_type: String,
    val service_version: String,
    val title: String,
    val url: String
): Parcelable