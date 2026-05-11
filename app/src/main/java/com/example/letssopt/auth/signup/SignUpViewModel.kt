package com.example.letssopt.auth.signup

import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.letssopt.RetrofitClient
import com.example.letssopt.auth.login.LoginUiStatus
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SignUpViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(SignUpUiState())
    val uiState = _uiState.asStateFlow()

    fun onLoginIdChange(value: String) {
        _uiState.update { it.copy(loginId = value) }
    }

    fun onPasswordChange(value: String) {
        _uiState.update { it.copy(password = value) }
    }

    fun onConfirmPasswordChange(value: String) {
        _uiState.update { it.copy(confirmpassword = value) }
    }

    fun onNameChange(value: String) {
        _uiState.update { it.copy(name = value) }
    }

    fun onEmailChange(value: String) {
        _uiState.update { it.copy(email = value) }
    }

    fun onAgeChange(value: String) {
        _uiState.update { it.copy(age = value) }
    }

    fun onPartChange(value: String) {
        _uiState.update { it.copy(part = value) }
    }

    // 회원가입 조건 체크
    private fun isValid() = Patterns.EMAIL_ADDRESS.matcher(_uiState.value.loginId)
        .matches() && _uiState.value.password.length >= 8 && _uiState.value.password.length < 12
            && _uiState.value.password == _uiState.value.confirmpassword

    // 회원가입할 때 정보(id, pw, name 등)를 서버에 저장
    fun signUp() {
        if (!isValid()) {
            _uiState.update { it.copy(status = SignUpUiStatus.Error("입력값을 확인해주세요")) }
            return
        }
        viewModelScope.launch {
            _uiState.update { it.copy(status = SignUpUiStatus.Loading) }

            runCatching {
                RetrofitClient.apiService.signUp(
                    SignUpRequestDto(
                        loginId = _uiState.value.loginId,
                        password = _uiState.value.password,
                        name = _uiState.value.name,
                        email = _uiState.value.email,
                        age = _uiState.value.age.toInt(),
                        part = _uiState.value.part
                    )
                )
            }.onSuccess { response ->
                if (response.isSuccessful) {
                    _uiState.update { it.copy(status = SignUpUiStatus.Success) }
                } else {
                    val message = response.body()?.message ?: "회원가입에 실패했습니다"
                    _uiState.update { it.copy(status = SignUpUiStatus.Error(message)) }
                }
            }.onFailure { e ->
                _uiState.update { it.copy(status = SignUpUiStatus.Error(e.message ?: "네트워크 오류가 발생했습니다")) }
            }
        }
    }
}