package com.example.letssopt.signup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.letssopt.component.CustomTextField
import com.example.letssopt.component.WeightSpacer
import com.example.letssopt.component.noRippleClickable
import com.example.letssopt.ui.theme.LETSSOPTColors
import com.example.letssopt.ui.theme.LETSSOPTTheme
import com.example.letssopt.ui.theme.Typography
import android.widget.Toast
import com.example.letssopt.AutoViewModel

@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier,
    email: String,
    password: String,
    password2: String,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onPassword2Change: (String) -> Unit,
    onSignUpClick: () -> Unit
) {


    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = LETSSOPTColors.BackGround)
            .padding(horizontal = 15.dp)
            .imePadding() // 키보드 높이만큼 자동으로 패딩 추가!
    ) {
        WeightSpacer(0.5f)

        Text(
            text = "watcha",
            modifier = Modifier.fillMaxWidth(),
            color = LETSSOPTColors.Primary_Red,
            textAlign = TextAlign.Center,
            style = Typography.logo
        )

        WeightSpacer(0.3f)

        Text(
            text = "회원가입",
            modifier = Modifier.fillMaxWidth(),
            style = Typography.h2,
            color = LETSSOPTColors.White
        )

        WeightSpacer(0.2f)

        // 이메일 입력
        Text(
            text = "이메일",
            modifier = Modifier.fillMaxWidth(),
            style = Typography.caption,
            color = LETSSOPTColors.Text_Secondary
        )

        CustomTextField(
            value = email,
            onValueChange = onEmailChange,
            placeholder = "이메일 주소를 입력하세요",
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next)
        )

        WeightSpacer(0.1f)

        // 비밀번호 입력
        Text(
            text = "비밀번호",
            modifier = Modifier.fillMaxWidth(),
            style = Typography.caption,
            color = LETSSOPTColors.Text_Secondary
        )

        CustomTextField(
            value = password,
            onValueChange = onPasswordChange,
            placeholder = "비밀번호를 입력하세요",
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next)
        )

        WeightSpacer(0.1f)

        // 비밀번호 확인
        Text(
            text = "비밀번호 확인",
            modifier = Modifier.fillMaxWidth(),
            style = Typography.caption,
            color = LETSSOPTColors.Text_Secondary
        )

        CustomTextField(
            value = password2,
            onValueChange = onPassword2Change,
            placeholder = "비밀번호를 다시 입력하세요",
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done)
            // 마지막 TextField는 엔터키 누르면 키보드 내려가도록!
        )

        WeightSpacer(0.8f)

        val isEnabled = email.isNotEmpty() && password.isNotEmpty() && password2.isNotEmpty()
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

        WeightSpacer(0.4f)
    }

}


@Preview(showBackground = true)
@Composable
private fun SignupPreview() {
    LETSSOPTTheme {
        SignUpScreen(
            email = "eunji",
            password = "12345678",
            password2 = "12345678",
            onEmailChange = {},
            onPasswordChange = {},
            onPassword2Change = {},
            onSignUpClick = {}
        )
    }
}
