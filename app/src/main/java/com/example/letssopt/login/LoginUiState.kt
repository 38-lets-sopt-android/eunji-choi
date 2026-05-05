package com.example.letssopt.login

sealed class LoginUiState {
    object Idle : LoginUiState()
    object Loading : LoginUiState()
    data class Success(val userId: Int) : LoginUiState()
    data class Error(val message: String) : LoginUiState()
}