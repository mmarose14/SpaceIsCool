package com.spaceiscool.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class APOD(
    val date: String? = null,
    val explanation: String? = null,
    val media_type: String? = null,
    val service_version: String? = null,
    val title: String? = null,
    val url: String? = null
): Parcelable