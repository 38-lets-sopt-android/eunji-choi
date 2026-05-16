package com.example.letssopt.auth.signup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.letssopt.component.HeightSpacer
import com.example.letssopt.component.noRippleClickable
import com.example.letssopt.ui.theme.LETSSOPTColors
import com.example.letssopt.ui.theme.LETSSOPTTheme
import com.example.letssopt.ui.theme.Typography

@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier,
    loginid: String,
    password: String,
    confirmpassword: String,
    name: String,
    email: String,
    age: String,
    part: String,
    onLoginIdChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onConfirmPasswordChange: (String) -> Unit,
    onNameChange: (String) -> Unit,
    onEmailChange: (String) -> Unit,
    onAgeChange: (String) -> Unit,
    onPartChange: (String) -> Unit,
    onSignUpClick: () -> Unit
) {

    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = LETSSOPTColors.BackGround)
            .padding(horizontal = 15.dp)
            .imePadding() // 키보드 높이만큼 자동으로 패딩 추가!
            .verticalScroll(state = scrollState)
    ) {
        HeightSpacer(30.dp)

        Text(
            text = "watcha",
            modifier = Modifier.fillMaxWidth(),
            color = LETSSOPTColors.Primary_Red,
            textAlign = TextAlign.Center,
            style = Typography.logo
        )

        HeightSpacer(30.dp)

        Text(
            text = "회원가입",
            modifier = Modifier.fillMaxWidth(),
            style = Typography.h2,
            color = LETSSOPTColors.White
        )

        HeightSpacer(30.dp)

        // 이메일 입력
        SignUpTextField(
            text = "이메일",
            onValueChange = onLoginIdChange,
            placeholder = "이메일 주소를 입력하세요",
            value = loginid,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next)
        )

        HeightSpacer(30.dp)

        // 비밀번호 입력
        SignUpTextField(
            text = "비밀번호",
            onValueChange = onPasswordChange,
            placeholder = "비밀번호를 입력하세요",
            value = password,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next)
        )

        HeightSpacer(30.dp)

        // 비밀번호 확인
        SignUpTextField(
            text = "비밀번호 확인",
            onValueChange = onConfirmPasswordChange,
            placeholder = "비밀번호를 다시 입력하세요",
            value = confirmpassword,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next)
        )

        HeightSpacer(30.dp)

        // 이름 입력
        SignUpTextField(
            text = "이름",
            onValueChange = onNameChange,
            placeholder = "이름을 입력하세요",
            value = name,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next)
        )

        HeightSpacer(30.dp)

        // 이메일 입력
        SignUpTextField(
            text = "이메일",
            onValueChange = onEmailChange,
            placeholder = "이메일을 입력하세요",
            value = email,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next)
        )

        HeightSpacer(30.dp)

        // 나이 입력
        SignUpTextField(
            text = "나이",
            onValueChange = onAgeChange,
            placeholder = "나이를 입력하세요",
            value = age,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next)
        )

        HeightSpacer(30.dp)

        // 파트 입력
        SignUpTextField(
            text = "파트",
            onValueChange = onPartChange,
            placeholder = "파트를 입력하세요",
            value = part,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done)
        )

        HeightSpacer(30.dp)
        val isEnabled = loginid.isNotEmpty() && password.isNotEmpty() && confirmpassword.isNotEmpty()
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(
                    if (isEnabled) LETSSOPTColors.Primary_Red else LETSSOPTColors.Disabled,
                    RoundedCornerShape(8.dp)
                )
                .noRippleClickable(
                    enabled = isEnabled,
                    onClick = onSignUpClick
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                "회원가입",
                style = Typography.body4,
                color = LETSSOPTColors.White,
            )
        }

        HeightSpacer(20.dp)
    }

}


@Preview(showBackground = true)
@Composable
private fun SignupPreview() {
    LETSSOPTTheme {
        SignUpScreen(
            loginid = "eunji",
            password = "12345678",
            confirmpassword = "12345678",
            name = "최은지",
            email = "eunji@naver.com",
            age = "22",
            part = "안드로이드",
            onLoginIdChange = {},
            onPasswordChange = {},
            onConfirmPasswordChange = {},
            onNameChange = {},
            onEmailChange = {},
            onAgeChange = {},
            onPartChange = {},
            onSignUpClick = {}
        )
    }
}
