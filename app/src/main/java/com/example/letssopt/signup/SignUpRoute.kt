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
        id = viewModel.id,
        password = viewModel.password,
        confirmpassword = viewModel.confirmpassword,
        name = viewModel.name,
        email = viewModel.email,
        age = viewModel.age,
        part = viewModel.part,
        onIdChange = { viewModel.onIdChange(it) },
        onPasswordChange = { viewModel.onPasswordChange(it) },
        onConfirmPasswordChange = { viewModel.onConfirmPasswordChange(it) },
        onNameChange = { viewModel.onNameChange(it)},
        onEmailChange = { viewModel.onEmailChange(it)},
        onAgeChange = { viewModel.onAgeChange(it)},
        onPartChange = { viewModel.onPartChange(it)},
        onSignUpClick = {
            if (viewModel.signupCheck()) {
                Toast.makeText(context, "회원가입에 성공했습니다", Toast.LENGTH_SHORT).show()
                navigateToLogin()}
            else {Toast.makeText(context, "회원가입에 실패했습니다", Toast.LENGTH_SHORT).show()}
        }
    )
}