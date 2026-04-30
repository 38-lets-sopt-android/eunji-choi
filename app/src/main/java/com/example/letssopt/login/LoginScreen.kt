package com.example.letssopt.login

import android.content.Intent
import android.widget.Toast
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.letssopt.component.CustomTextField
import com.example.letssopt.component.WeightSpacer
import com.example.letssopt.component.noRippleClickable
import com.example.letssopt.signup.SignUpViewModel
import com.example.letssopt.ui.theme.LETSSOPTColors
import com.example.letssopt.ui.theme.LETSSOPTTheme
import com.example.letssopt.ui.theme.Typography
import kotlinx.serialization.Serializable


@Composable
fun LoginScreen(
    navigateToHome: () -> Unit,   // 로그인 성공하면 이거 호출
    navigateToSignUp: () -> Unit,  // 회원가입 누르면 이거 호출
    modifier: Modifier = Modifier,
    viewModel: SignUpViewModel = viewModel()) {

    val context = LocalContext.current

    val email by viewModel.email.collectAsState()
    val password by viewModel.password.collectAsState()

    var emailinput by remember { mutableStateOf("") }
    var pwinput by remember { mutableStateOf("") }



    Column(
        modifier = modifier
            .fillMaxSize()
            .background(LETSSOPTColors.BackGround)
            .padding(horizontal = 16.dp)
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
            value = emailinput,
            onValueChange = { emailinput = it },
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
            value = pwinput,
            onValueChange = { pwinput = it },
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
                        onClick = {navigateToSignUp()}
                    )
            )
        }

        WeightSpacer(0.05f)

        val logincondition = emailinput.isNotEmpty() && pwinput.isNotEmpty() &&
                emailinput == email && pwinput == password
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(LETSSOPTColors.Primary_Red, RoundedCornerShape(8.dp))
                .noRippleClickable(
                    enabled = true,
                    onClick = {
                        // email, pw가 같다는 조건 만족할 때만 'MainActivity'로 이동!
                        if (logincondition) {
                            //로그인 여부 저장
                            LoginSave.prefs.setBoolean("is_logged_in", true)
                            navigateToHome()

                            Toast.makeText(context, "로그인에 성공했습니다", Toast.LENGTH_SHORT).show()

//                            (context as? LoginActivity)?.finish()
                        } else {
                            Toast.makeText(context, "로그인에 실패했습니다", Toast.LENGTH_SHORT).show()
                        }
                    }
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                "로그인",
                style = Typography.body4,
                color = if (logincondition) LETSSOPTColors.placeholder else LETSSOPTColors.White,
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
            navigateToHome = {},
            navigateToSignUp = {}
        )
    }
}