package com.garikcarrot.browserfilter.data.database

import androidx.room.*
import com.garikcarrot.browserfilter.data.models.FilterDto

@Dao
interface IFilterDao {

    @Insert
    fun newFilter(filter: FilterDto)

    @Update
    fun updateFilter(filter: FilterDto)

    @Delete
    fun deleteFilter(filter: FilterDto)

    @Query("SELECT * FROM FilterDto")
    fun getFilters(): List<FilterDto>

    @Query("SELECT * FROM FilterDto WHERE id LIKE :id")
    fun getFilter(id: Int): FilterDto
}