package com.example.letssopt.signup

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.letssopt.R
import com.example.letssopt.component.CustomTextField
import com.example.letssopt.component.WeightSpacer
import com.example.letssopt.component.noRippleClickable
import com.example.letssopt.login.LoginActivity
import com.example.letssopt.ui.theme.LETSSOPTColors
import com.example.letssopt.ui.theme.LETSSOPTTheme
import com.example.letssopt.ui.theme.Typography


class SignUpActivity : ComponentActivity() { // 회원가입 activity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            LETSSOPTTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Signup(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }

    }
}

@Composable
fun Signup(modifier: Modifier = Modifier) {
    val context = LocalContext.current

    var pw by remember { mutableStateOf("") }
    var pw2 by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

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
            onValueChange = { email = it },
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
            value = pw,
            onValueChange = { pw = it },
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
            value = pw2,
            onValueChange = { pw2 = it },
            placeholder = "비밀번호를 다시 입력하세요",
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done)
            // 마지막 TextField는 엔터키 누르면 키보드 내려가도록!
        )

        WeightSpacer(0.8f)

        val isEnabled = email.isNotEmpty() && pw.isNotEmpty() && pw2.isNotEmpty()
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background( if (isEnabled) LETSSOPTColors.Primary_Red else LETSSOPTColors.Disabled,
                    RoundedCornerShape(8.dp))
                .noRippleClickable(
                    enabled = isEnabled,
                    onClick = {
                        // 회원가입 조건 확인용 if문
                        // 조건 : email 형식, pw 길이 8~12자, 비밀번호 == 비밀번호 확인
                        if (Patterns.EMAIL_ADDRESS.matcher(email)
                                .matches() && pw.length >= 8 && pw.length < 12 && pw == pw2
                        ) {
                            val intent = Intent(context, LoginActivity::class.java)
                            // putExtra로 email, password 전달
                            intent.putExtra("email", email)
                            intent.putExtra("password", pw)
                            context.startActivity(intent)
                            Toast.makeText(context, "회원가입에 성공했습니다", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(context, "회원가입에 실패했습니다", Toast.LENGTH_SHORT).show()
                        }
                    }
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
        Signup()
    }
}
