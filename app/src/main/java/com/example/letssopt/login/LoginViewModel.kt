package com.example.letssopt.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.letssopt.RetrofitClient
import com.example.letssopt.SaveInfo
import com.example.letssopt.signup.SignUpRequest
import com.example.letssopt.signup.SignUpUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    private val _uiState = MutableStateFlow<LoginUiState>(LoginUiState.Idle)
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()

    val saveid = SaveInfo.prefs.getString("id")
    val savepassword = SaveInfo.prefs.getString("password")

    var id by mutableStateOf("")
    var password by mutableStateOf("")

    fun onIdChange(value: String) { id = value }

    fun onPasswordChange(value: String) { password = value }

    // 로그인 조건 체크
    private fun isValid() = id.isNotEmpty() && password.isNotEmpty() && id == saveid && password == savepassword

    fun login() {
        if (!isValid()) {
            _uiState.value = LoginUiState.Error("입력값을 확인해주세요")
            return
        }
        viewModelScope.launch {

            _uiState.value = LoginUiState.Loading

            runCatching {
                RetrofitClient.apiService.logIn(
                    LoginRequest(
                        loginId = id,
                        password = password
                    )
                )
            }.onSuccess { response ->
                if (response.isSuccessful) {
                    val userId = response.body()?.data?.userId
                    _uiState.value = LoginUiState.Success(userId = userId ?: 0)
                } else {
                    val message = response.body()?.message ?: "회원가입에 실패했습니다"
                    _uiState.value = LoginUiState.Error(message)
                }
            }.onFailure { e ->
                _uiState.value = LoginUiState.Error(e.message ?: "네트워크 오류가 발생했습니다")
            }
        }
    }
}