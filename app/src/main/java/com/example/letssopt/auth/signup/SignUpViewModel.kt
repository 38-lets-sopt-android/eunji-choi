package com.example.letssopt.auth.signup

import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.letssopt.RetrofitClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SignUpViewModel : ViewModel() {

    private val _uiState = MutableStateFlow<SignUpUiState>(SignUpUiState.Idle)
    val uiState: StateFlow<SignUpUiState> = _uiState.asStateFlow()


    var loginid by mutableStateOf("")
    var password by mutableStateOf("")
    var confirmpassword by mutableStateOf("")
    var name by mutableStateOf("")
    var email by mutableStateOf("")
    var age by mutableStateOf("")
    var part by mutableStateOf("")

    fun onLoginIdChange(value: String) {
        loginid = value
    }

    fun onPasswordChange(value: String) {
        password = value
    }

    fun onConfirmPasswordChange(value: String) {
        confirmpassword = value
    }

    fun onNameChange(value: String) {
        name = value
    }

    fun onEmailChange(value: String) {
        email = value
    }

    fun onAgeChange(value: String) {
        age = value
    }

    fun onPartChange(value: String) {
        part = value
    }

    // 회원가입 조건 체크
    private fun isValid() = Patterns.EMAIL_ADDRESS.matcher(loginid)
        .matches() && password.length >= 8 && password.length < 12 && password == confirmpassword

    // 회원가입할 때 정보(id, pw, name 등)를 서버에 저장
    fun signUp() {
        if (!isValid()) {
            _uiState.value = SignUpUiState.Error("입력값을 확인해주세요")
            return
        }
        viewModelScope.launch {

            _uiState.value = SignUpUiState.Loading

            runCatching {
                RetrofitClient.apiService.signUp(
                    SignUpRequestDto(
                        loginId = loginid,
                        password = password,
                        name = name,
                        email = email,
                        age = age.toInt(),
                        part = part
                    )
                )
            }.onSuccess { response ->
                if (response.isSuccessful) {
                    _uiState.value = SignUpUiState.Success
                } else {
                    val message = response.body()?.message ?: "회원가입에 실패했습니다"
                    _uiState.value = SignUpUiState.Error(message)
                }
            }.onFailure { e ->
                _uiState.value = SignUpUiState.Error(e.message ?: "네트워크 오류가 발생했습니다")
            }
        }
    }
}