package com.garikcarrot.browserfilter.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.garikcarrot.browserfilter.data.models.FilterDto

@Database(version = 1, entities = [FilterDto::class])
abstract class IFilterDatabase : RoomDatabase() {
    abstract fun filtersDao(): IFilterDao
}