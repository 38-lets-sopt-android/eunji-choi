package com.example.letssopt

import android.app.Application

class saveinfo : Application() {

    companion object {
        lateinit var prefs: PreferenceUtil
            private set
    }

    override fun onCreate() {
        prefs = PreferenceUtil(applicationContext)
        super.onCreate()
    }
}