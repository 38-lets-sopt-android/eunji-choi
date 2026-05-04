package com.example.letssopt.signup

import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.letssopt.SaveInfo

class SignUpViewModel : ViewModel() {
    var id by mutableStateOf("")
    var password by mutableStateOf("")
    var confirmpassword by mutableStateOf("")
    var name by mutableStateOf("")
    var email by mutableStateOf("")
    var age by mutableStateOf("")
    var part by mutableStateOf("")

    fun onIdChange(value: String) { id = value }
    fun onPasswordChange(value: String) { password = value }
    fun onConfirmPasswordChange(value: String) { confirmpassword = value }
    fun onNameChange(value: String) { name = value }
    fun onEmailChange(value: String) { email = value }
    fun onAgeChange(value: String) { age = value }
    fun onPartChange(value: String) { part = value }

    // 회원가입했던 id, password 저장 : 로그인 때 비교 용도
    fun saveInfo(id: String, password: String) {
        SaveInfo.prefs.setString("id", id)
        SaveInfo.prefs.setString("password", password)
        SaveInfo.prefs.setString("name", name)
        SaveInfo.prefs.setString("email", email)
        SaveInfo.prefs.setString("age", age)
        SaveInfo.prefs.setString("part", part)
    }

    // 회원가입 조건 체크 + 조건 만족 시 id, pw 저장
    fun signupCheck() : Boolean {
        val isvalid = Patterns.EMAIL_ADDRESS.matcher(id)
            .matches() && password.length >= 8 && password.length < 12 && password == confirmpassword

        if (isvalid) saveInfo(id, password)

        return isvalid
    }
}