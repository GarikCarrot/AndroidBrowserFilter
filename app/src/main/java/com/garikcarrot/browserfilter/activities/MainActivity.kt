package com.garikcarrot.browserfilter.activities

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.garikcarrot.browserfilter.R
import com.garikcarrot.browserfilter.data.repository.IFilterRepository
import com.garikcarrot.browserfilter.filterlist.FilterListFragment
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.fragment.android.setupKoinFragmentFactory
import org.koin.core.context.startKoin
import org.koin.core.parameter.parametersOf

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setupKoinFragmentFactory()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.container, FilterListFragment::class.java, null, null).commit()
    }
}
