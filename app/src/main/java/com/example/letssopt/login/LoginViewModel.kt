package com.example.letssopt.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.letssopt.SaveInfo

class LoginViewModel : ViewModel() {
    val saveemail = SaveInfo.prefs.getString("email")
    val savepassword = SaveInfo.prefs.getString("password")

    var email by mutableStateOf("")
    var password by mutableStateOf("")

    fun onEmailChange(value: String) { email = value }

    fun onPasswordChange(value: String) { password = value }

    // 로그인 조건 체크 + 조건 만족 시 pref에 저장
    fun LoginCheck() : Boolean {
        val logincondition = if(email == saveemail && password == savepassword) true
            else false

        SaveLoginInfo(logincondition)

        return logincondition
    }

    fun SaveLoginInfo(
        isSaved: Boolean
    ) {
        if (isSaved) {
            SaveInfo.prefs.setBoolean("is_logged_in", true)
        }
    }
}