package com.garikcarrot.browserfilter.data.repository

import com.garikcarrot.browserfilter.entity.Filter

interface IFilterRepository {
    suspend fun getFilter(id: Int): Filter
    suspend fun getFilterList(): List<Filter>
    suspend fun updateFilter(filter: Filter)
    suspend fun deleteFilter(filter: Filter)
}