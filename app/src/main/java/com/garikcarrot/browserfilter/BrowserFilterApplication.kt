package com.garikcarrot.browserfilter

import android.app.Application
import androidx.room.Room
import com.garikcarrot.browserfilter.data.database.IFilterDao
import com.garikcarrot.browserfilter.data.database.IFilterDatabase
import com.garikcarrot.browserfilter.data.prefs.DefaultPrefs
import com.garikcarrot.browserfilter.data.prefs.IDefaultPrefs
import com.garikcarrot.browserfilter.data.repository.FilterRepository
import com.garikcarrot.browserfilter.data.repository.IFilterRepository
import com.garikcarrot.browserfilter.di.FilterListModule
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.fragment.koin.fragmentFactory
import org.koin.core.context.startKoin
import org.koin.dsl.module

class BrowserFilterApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BrowserFilterApplication)
            modules(ApplicationModule, FilterListModule)
            fragmentFactory()
        }
    }

    companion object {
        private val ApplicationModule = module {

            single<IFilterDatabase> { Room.databaseBuilder(get(), IFilterDatabase::class.java, "database").build() }
            single<IFilterDao> { get<IFilterDatabase>().filtersDao() }
            single<IDefaultPrefs> { DefaultPrefs(get()) }
            single<IFilterRepository> { FilterRepository(get()) }
        }
    }
}