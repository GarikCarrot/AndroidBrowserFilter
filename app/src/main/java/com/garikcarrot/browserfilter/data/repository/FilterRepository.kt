package com.garikcarrot.browserfilter.data.repository

import com.garikcarrot.browserfilter.data.database.IFilterDao
import com.garikcarrot.browserfilter.data.models.toDto
import com.garikcarrot.browserfilter.data.models.toEntity
import com.garikcarrot.browserfilter.entity.Filter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FilterRepository(private val dao: IFilterDao) :
    IFilterRepository {
    override suspend fun getFilter(id: Int) = withContext(Dispatchers.IO) {
        dao.getFilter(id).toEntity()
    }

    override suspend fun getFilterList() = withContext(Dispatchers.IO) {
        dao.getFilters().toEntity()
    }

    override suspend fun updateFilter(filter: Filter) {
        if (filter.id == -1) {
            dao.newFilter(filter.toDto())
        } else {
            dao.updateFilter(filter.toDto())
        }
    }

    override suspend fun deleteFilter(filter: Filter) {
        dao.deleteFilter(filter.toDto())
    }
}
