package com.example.letssopt

import android.app.Application

class SaveInfo : Application() {

    companion object {
        lateinit var prefs: PreferenceUtil
            private set
    }

    override fun onCreate() {
        prefs = PreferenceUtil(applicationContext)
        super.onCreate()
    }
}