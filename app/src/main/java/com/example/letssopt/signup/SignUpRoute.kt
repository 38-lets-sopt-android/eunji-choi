package com.example.letssopt.signup

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun SignUpRoute (
    navigateToLogin: () -> Unit
){
    val viewModel: SignUpViewModel = viewModel()

    val context = LocalContext.current

    SignUpScreen(
        email = viewModel.email,
        password = viewModel.password,
        password2 = viewModel.password2,
        onEmailChange = { viewModel.onEmailChange(it) },
        onPasswordChange = { viewModel.onPasswordChange(it) },
        onPassword2Change = { viewModel.onPassword2Change(it) },
        onSignUpClick = {
            if (viewModel.signupCheck()) {
                Toast.makeText(context, "회원가입에 성공했습니다", Toast.LENGTH_SHORT).show()
                navigateToLogin()}
            else {Toast.makeText(context, "회원가입에 실패했습니다", Toast.LENGTH_SHORT).show()}
        }
    )
}