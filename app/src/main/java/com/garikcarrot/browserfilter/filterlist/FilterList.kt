package com.garikcarrot.browserfilter.filterlist

import com.garikcarrot.browserfilter.entity.Filter

interface FilterList {
    interface View {
        fun showItems(filters: List<Filter>)
    }

    interface Presenter {
        fun onResume()
    }

    interface Interactor {
        suspend fun getItems(): List<Filter>
    }
}