package com.garikcarrot.browserfilter.filterlist

import com.garikcarrot.browserfilter.data.repository.IFilterRepository
import com.garikcarrot.browserfilter.entity.Filter

class FilterListInteractor(
    private val repository: IFilterRepository
) : FilterList.Interactor {
    override suspend fun getItems(): List<Filter> {
        return repository.getFilterList()
    }
}