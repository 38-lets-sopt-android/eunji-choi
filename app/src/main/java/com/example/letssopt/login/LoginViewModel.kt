package com.example.letssopt.login

import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    val isLoggedIn = LoginSave.prefs.getBoolean("is_logged_in", false)

}