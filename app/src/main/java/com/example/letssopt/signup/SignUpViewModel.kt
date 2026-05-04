package com.example.letssopt.signup

import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.letssopt.SaveInfo

class SignUpViewModel : ViewModel() {
    var email by mutableStateOf("")
    var password by mutableStateOf("")
    var confirmpassword by mutableStateOf("")

    fun onEmailChange(value: String) { email = value }

    fun onPasswordChange(value: String) { password = value }
    fun onPassword2Change(value: String) { confirmpassword = value }

    // 회원가입했던 email, password 저장 : 로그인 때 비교 용도
    fun saveInfo(email: String, password: String) {
        SaveInfo.prefs.setString("email", email)
        SaveInfo.prefs.setString("password", password)
    }

    // 회원가입 조건 체크 + 조건 만족 시 email, pw 저장
    fun signupCheck() : Boolean {
        val isvalid = Patterns.EMAIL_ADDRESS.matcher(email)
            .matches() && password.length >= 8 && password.length < 12 && password == confirmpassword

        if (isvalid) saveInfo(email, password)

        return isvalid
    }
}