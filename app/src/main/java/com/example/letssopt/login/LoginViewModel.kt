package com.example.letssopt.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.letssopt.RetrofitClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState = _uiState.asStateFlow()



    fun onLoginIdChange(value: String) {
        _uiState.update { it.copy(loginId = value) }
    }

    fun onPasswordChange(value: String) {
        _uiState.update { it.copy(password = value) }
    }

    // 로그인 조건 체크
    private fun isValid() = _uiState.value.loginId.isNotEmpty() && _uiState.value.password.isNotEmpty()

    fun login() {
        if (!isValid()) {
            _uiState.update { it.copy(status = LoginUiStatus.Error("입력값을 확인해주세요")) }
            return
        }
        viewModelScope.launch {
            _uiState.update { it.copy(status = LoginUiStatus.Loading) }

            runCatching {
                RetrofitClient.apiService.logIn(
                    LoginRequestDto(
                        loginId = _uiState.value.loginId,
                        password = _uiState.value.password
                    )
                )
            }.onSuccess { response ->
                if (response.isSuccessful) {
                    val userId = response.body()?.data?.userId
                    _uiState.update { it.copy(status = LoginUiStatus.Success(userId = userId ?: 0)) }
                } else {
                    val message = response.body()?.message ?: "회원가입에 실패했습니다"
                    _uiState.update { it.copy(status = LoginUiStatus.Error(message)) }
                }
            }.onFailure { e ->
                _uiState.update { it.copy(status = LoginUiStatus.Error(e.message ?: "네트워크 오류가 발생했습니다")) }
            }
        }
    }
}