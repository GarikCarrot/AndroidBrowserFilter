package com.garikcarrot.browserfilter.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Filter(
    val id: Int,
    val pattern: String,
    val packageName: String,
    val activityName: String
) : Parcelable