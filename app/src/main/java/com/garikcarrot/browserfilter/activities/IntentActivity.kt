package com.garikcarrot.browserfilter.activities

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class IntentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (intent == null || intent.action != Intent.ACTION_VIEW || intent.data == null) {
            finish()
            return
        }

        val manager = applicationContext.packageManager
        val newIntent = Intent(Intent.ACTION_VIEW, clearAways(intent))

        val activities = manager.queryIntentActivities(newIntent, PackageManager.MATCH_ALL).filter {
            it.activityInfo.packageName != "com.garikcarrot.browserfilter"
        }

        if (activities.isNotEmpty()) {
            val selected = (activities.find { it.activityInfo.packageName == "org.mozilla.fenix" } ?: activities[0]).activityInfo
            startActivity(newIntent.apply { setClassName(selected.packageName, selected.name) })
        }
        finish()
    }

    private fun clearAways(intent: Intent): Uri {
        val data = intent.data!!
        val url = intent.dataString ?: return data
        return when {
            url.startsWith("https://m.vk.com/away") -> {
                val to = data.getQueryParameter("to") ?: return data
                return Uri.parse(to)
            }
            else -> data
        }
    }
}
