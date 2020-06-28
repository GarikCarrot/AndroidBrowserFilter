package com.garikcarrot.browserfilter.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "FilterDto")
class FilterDto(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val pattern: String,
    val packageName: String,
    val activityName: String
)