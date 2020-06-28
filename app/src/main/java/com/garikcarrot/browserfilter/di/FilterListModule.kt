package com.garikcarrot.browserfilter.di

import com.garikcarrot.browserfilter.filterlist.FilterList
import com.garikcarrot.browserfilter.filterlist.FilterListFragment
import com.garikcarrot.browserfilter.filterlist.FilterListInteractor
import com.garikcarrot.browserfilter.filterlist.FilterListPresenter
import org.koin.androidx.fragment.dsl.fragment
import org.koin.dsl.module

val FilterListModule = module {
    fragment { FilterListFragment() }
    single<FilterList.View> { get<FilterListFragment>() }
    single<FilterList.Presenter> { FilterListPresenter(get(), get()) }
    single<FilterList.Interactor> { FilterListInteractor(get()) }
}