package com.example.letssopt.auth.signup

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.letssopt.auth.login.LoginUiStatus

data class SignUpUiState(
    val loginId : String = "",
    val password : String = "",
    var confirmpassword : String = "",
    var name : String = "",
    var email : String = "",
    var age : String = "",
    var part : String = "",
    val status: SignUpUiStatus = SignUpUiStatus.Idle
)

sealed class SignUpUiStatus {
    object Idle : SignUpUiStatus()
    object Loading : SignUpUiStatus()
    object Success : SignUpUiStatus()
    data class Error(val message: String) : SignUpUiStatus()
}