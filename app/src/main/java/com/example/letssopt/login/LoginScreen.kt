package com.example.letssopt.login


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.letssopt.component.CustomTextField
import com.example.letssopt.component.WeightSpacer
import com.example.letssopt.component.noRippleClickable
import com.example.letssopt.ui.theme.LETSSOPTColors
import com.example.letssopt.ui.theme.LETSSOPTTheme
import com.example.letssopt.ui.theme.Typography




@Composable
fun LoginScreen(
    email: String,
    password: String,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onSignUpClick: () -> Unit,
    onLoginClick: () -> Unit,
    modifier: Modifier = Modifier) {

    val context = LocalContext.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(LETSSOPTColors.BackGround)
            .padding(horizontal = 15.dp)
            .imePadding() // 키보드 높이만큼 자동으로 패딩 추가!
    )
    {
        WeightSpacer(0.5f)

        Text(
            text = "watcha",
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
            style = Typography.logo,
            color = LETSSOPTColors.Primary_Red
        )

        WeightSpacer(0.3f)

        Text(
            text = "이메일로 로그인",
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

        WeightSpacer(0.2f)

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
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            visualTransformation = PasswordVisualTransformation()
        )

        WeightSpacer(1f)

        // text 2개 가로로 나열하기 위해 Row에 만듦
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center

        ) {
            Text(
                text = "아직 계정이 없으신가요?",
                style = Typography.caption,
                color = LETSSOPTColors.Text_Secondary
            )

            // 회원가입 글자만 click 가능하게끔 '회원가입' text 생성!
            Text(
                text = "회원가입",
                style = Typography.caption,
                color = LETSSOPTColors.Text_Secondary,
                modifier = Modifier
                    .padding(3.dp)
                    .clickable(
                        onClick = onSignUpClick
                    )
            )
        }

        WeightSpacer(0.05f)

        val IsEnabled = email.isNotEmpty() && password.isNotEmpty()
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(color = if (IsEnabled) LETSSOPTColors.Primary_Red
                    else LETSSOPTColors.Disabled,
                    shape = RoundedCornerShape(8.dp))
                .noRippleClickable(
                    enabled = true,
                    onClick = onLoginClick
                ),
            contentAlignment = Alignment.Center
        ) {

            Text(
                "로그인",
                style = Typography.body4,
                color = LETSSOPTColors.White,
            )
        }

        WeightSpacer(0.4f)

    }

}

@Preview(showBackground = true)
@Composable
private fun LoginPreview() {
    LETSSOPTTheme {
        LoginScreen(
            email = "eunji",
            password = "12345678",
            onEmailChange = {},
            onPasswordChange = {},
            onLoginClick = {},
            onSignUpClick = {}
        )
    }
}