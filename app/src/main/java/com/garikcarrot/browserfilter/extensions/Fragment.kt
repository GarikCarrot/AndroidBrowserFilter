package com.garikcarrot.browserfilter.extensions

import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

fun Fragment.getToolbar(): ActionBar? = (activity as AppCompatActivity).supportActionBar