package com.garikcarrot.browserfilter.data.prefs

import com.garikcarrot.browserfilter.entity.Filter

interface IDefaultPrefs {
    fun getFilter(): Filter?
    fun setFilter(filter: Filter?)
}