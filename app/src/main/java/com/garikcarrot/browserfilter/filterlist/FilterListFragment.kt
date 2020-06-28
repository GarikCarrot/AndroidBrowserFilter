package com.garikcarrot.browserfilter.filterlist

import androidx.fragment.app.Fragment
import com.garikcarrot.browserfilter.R
import com.garikcarrot.browserfilter.entity.Filter
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class FilterListFragment : Fragment(R.layout.fragment_filter_list), FilterList.View {

    private val presenter: FilterList.Presenter by inject { parametersOf() }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun showItems(filters: List<Filter>) {
        TODO("Not yet implemented")
    }
}