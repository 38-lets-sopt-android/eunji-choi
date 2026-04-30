package com.example.letssopt.login

import android.app.Application
import com.example.letssopt.signup.PreferenceUtil

class LoginSave : Application() {

    companion object {
        lateinit var prefs: PreferenceUtil
            private set
    }

    override fun onCreate() {
        prefs = PreferenceUtil(applicationContext)
        super.onCreate()
    }


}