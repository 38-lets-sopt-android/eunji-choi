package com.example.letssopt.login

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.letssopt.signup.SignUpUiState

@Composable
fun LoginRoute (
    navigateToHome: () -> Unit,   // 로그인 성공하면 이거 호출
    navigateToSignUp: () -> Unit,  // 회원가입 누르면 이거 호출
){
    val viewModel: LoginViewModel = viewModel()
    val context = LocalContext.current
    val uiState by viewModel.uiState.collectAsState()

    //Uistate 변화 감지
    LaunchedEffect(uiState) {
        when (uiState) {
            is LoginUiState.Success -> {
                Toast.makeText(context, "로그인에 성공했습니다", Toast.LENGTH_SHORT).show()
                navigateToHome()
            }
            is LoginUiState.Error -> {
                val message = (uiState as LoginUiState.Error).message
                Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
            }
            else -> {}
        }
    }

    LoginScreen(
        id = viewModel.id,
        password = viewModel.password,
        onIdChange = { viewModel.onIdChange(it) },
        onPasswordChange = { viewModel.onPasswordChange(it) },
        onSignUpClick = { navigateToSignUp() },
        onLoginClick = { viewModel.login() }
    )
}
