package com.example.letssopt.auth.login

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.letssopt.SaveInfo

@Composable
fun LoginRoute(
    navigateToHome: () -> Unit,   // 로그인 성공하면 이거 호출
    navigateToSignUp: () -> Unit,  // 회원가입 누르면 이거 호출
) {
    val viewModel: LoginViewModel = viewModel()
    val context = LocalContext.current
    val uiState by viewModel.uiState.collectAsState()

    //Uistate 변화 감지
    LaunchedEffect(uiState) {
        when (uiState) {
            is LoginUiState.Success -> {
                Toast.makeText(context, "로그인에 성공했습니다", Toast.LENGTH_SHORT).show()
                SaveInfo.prefs.setBoolean("Is_Logged_In", true)
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
        loginid = viewModel.loginid,
        password = viewModel.password,
        onLoginIdChange = { viewModel.onLoginIdChange(it) },
        onPasswordChange = { viewModel.onPasswordChange(it) },
        onSignUpClick = { navigateToSignUp() },
        onLoginClick = { viewModel.login() }
    )
}
