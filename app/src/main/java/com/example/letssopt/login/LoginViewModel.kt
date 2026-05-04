package com.example.letssopt.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.letssopt.SaveInfo

class LoginViewModel : ViewModel() {
    val saveid = SaveInfo.prefs.getString("id")
    val savepassword = SaveInfo.prefs.getString("password")

    var id by mutableStateOf("")
    var password by mutableStateOf("")

    fun onIdChange(value: String) { id = value }

    fun onPasswordChange(value: String) { password = value }

    // 로그인 조건 체크 + 조건 만족 시 pref에 저장
    fun LoginCheck() : Boolean {
        val logincondition = if(id.isNotEmpty() && password.isNotEmpty() && id == saveid && password == savepassword) true
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