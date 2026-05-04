package com.example.letssopt.login

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun LoginRoute (
    navigateToHome: () -> Unit,   // 로그인 성공하면 이거 호출
    navigateToSignUp: () -> Unit,  // 회원가입 누르면 이거 호출
){
    val viewModel: LoginViewModel = viewModel()

    val context = LocalContext.current

    LoginScreen(
        id = viewModel.id,
        password = viewModel.password,
        onIdChange = { viewModel.onIdChange(it) },
        onPasswordChange = { viewModel.onPasswordChange(it) },
        onSignUpClick = { navigateToSignUp() },
        onLoginClick = {
            if (viewModel.LoginCheck()) {
                Toast.makeText(context, "로그인에 성공했습니다", Toast.LENGTH_SHORT).show()
                navigateToHome()}
            else {Toast.makeText(context, "로그인에 실패했습니다", Toast.LENGTH_SHORT).show()}
        }
    )
}