package com.example.letssopt

import android.util.Patterns
import androidx.lifecycle.ViewModel
import com.example.letssopt.navigation.Home
import com.example.letssopt.navigation.HomeGraph
import com.example.letssopt.navigation.Login
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class AutoViewModel : ViewModel() {

    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email

    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password

    // 회원가입했던 email, password 저장 : 로그인 때 비교 용도
    fun saveInfo(email: String, password: String) {
        _email.value = email
        _password.value = password
    }

    // 회원가입 조건 체크 + 조건 만족 시 email, pw 저장
    fun signCheck(email: String, pw: String, pw2: String) : Boolean {
        val isvalid = Patterns.EMAIL_ADDRESS.matcher(email)
                .matches() && pw.length >= 8 && pw.length < 12 && pw == pw2

        if (isvalid) saveInfo(email, pw)

        return isvalid
    }

    // 로그인 조건 체크 + 조건 만족 시 pref에 저장
    fun loginCheck(inputemail: String, inputpw: String) : Boolean {
        val logincondition =
            if( inputemail.isNotEmpty() && inputpw.isNotEmpty()
            && inputemail == _email.value
            && inputpw == _password.value ) true
            else false

        if (logincondition) {
            saveinfo.prefs.setBoolean("is_logged_in", true)
        }

        return logincondition
    }

    val startDestination = if (saveinfo.prefs.getBoolean("is_logged_in", false)) HomeGraph else Login
}