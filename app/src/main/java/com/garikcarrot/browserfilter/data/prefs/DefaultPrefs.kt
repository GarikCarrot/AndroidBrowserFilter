package com.garikcarrot.browserfilter.data.prefs

import android.content.Context
import com.garikcarrot.browserfilter.entity.Filter

class DefaultPrefs(context: Context) : IDefaultPrefs {
    private val sharedPreferences = context.getSharedPreferences("Default", Context.MODE_PRIVATE)

    override fun getFilter(): Filter? {
        val p = sharedPreferences.getString(PACKAGE, null)
        val b = sharedPreferences.getString(BROWSER, null)
        p ?: return null
        b ?: return null
        return Filter(0, "", p, b)
    }


    override fun setFilter(filter: Filter?) {
        if (filter == null) {
            sharedPreferences.edit().remove(PACKAGE).remove(BROWSER).apply()
        } else {
            sharedPreferences.edit()
                .putString(PACKAGE, filter.packageName)
                .putString(PACKAGE, filter.activityName)
                .apply()
        }
    }

    companion object {
        const val PACKAGE = "package"
        const val BROWSER = "browser"
    }
}