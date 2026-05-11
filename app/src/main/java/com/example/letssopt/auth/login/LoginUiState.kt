package com.example.letssopt.auth.login


data class LoginUiState(
    val loginId : String = "",
    val password : String = "",
    val status: LoginUiStatus = LoginUiStatus.Idle
)

sealed class LoginUiStatus {
    object Idle : LoginUiStatus()
    object Loading : LoginUiStatus()
    data class Success(val userId: Int) : LoginUiStatus()
    data class Error(val message: String) : LoginUiStatus()
}