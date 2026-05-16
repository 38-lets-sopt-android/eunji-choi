package com.example.letssopt.auth.signup

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun SignUpRoute(
    navigateToLogin: () -> Unit
) {
    val viewModel: SignUpViewModel = viewModel()
    val context = LocalContext.current
    val uiState by viewModel.uiState.collectAsState()

    //Uistate 변화 감지
    LaunchedEffect(uiState.status) {
        when (uiState.status) {
            is SignUpUiStatus.Success -> {
                Toast.makeText(context, "회원가입에 성공했습니다", Toast.LENGTH_SHORT).show()
                navigateToLogin()
            }

            is SignUpUiStatus.Error -> {
                val message = (uiState as SignUpUiStatus.Error).message
                Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
            }

            else -> {}
        }
    }

    SignUpScreen(
        loginid = uiState.loginId,
        password = uiState.password,
        confirmpassword = uiState.confirmpassword,
        name = uiState.name,
        email = uiState.email,
        age = uiState.age,
        part = uiState.part,
        onLoginIdChange = { viewModel.onLoginIdChange(it) },
        onPasswordChange = { viewModel.onPasswordChange(it) },
        onConfirmPasswordChange = { viewModel.onConfirmPasswordChange(it) },
        onNameChange = { viewModel.onNameChange(it) },
        onEmailChange = { viewModel.onEmailChange(it) },
        onAgeChange = { viewModel.onAgeChange(it) },
        onPartChange = { viewModel.onPartChange(it) },
        onSignUpClick = { viewModel.signUp() }
    )
}