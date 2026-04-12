package com.example.letssopt

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.letssopt.ui.theme.LETSSOPTTheme
import java.util.regex.Pattern


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

private var pattern: Pattern = Patterns.EMAIL_ADDRESS

@Composable
fun Signup(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val intent = Intent(context, LoginActivity::class.java)

    var pw by remember { mutableStateOf("") }
    var pw2 by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(horizontal = 15.dp)
    ) {
        CustomSpacer(80)

        Text(
            text = "watcha",
            color = Color.Red,
            fontSize = 40.sp,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily(Font(R.font.pretendard_bold)),
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding()
        )

        CustomSpacer(30)

        Text(
            text = "회원가입",
            fontFamily = FontFamily(Font(R.font.pretendard_bold)),
            fontSize = 20.sp,
            color = Color.White,
            modifier = Modifier
        )

        CustomSpacer(30)

        // 이메일 입력
        Text(
            text = "이메일",
            fontFamily = FontFamily(Font(R.font.pretendard_regular)),
            fontSize = 15.sp,
            color = Color.Gray,
            modifier = Modifier
        )

        CustomTextField(
            value = email,
            onValueChange = { email = it },
            label = "이메일 주소를 입력하세요"
        )

        CustomSpacer(10)

        // 비밀번호 입력
        Text(
            text = "비밀번호",
            fontFamily = FontFamily(Font(R.font.pretendard_regular)),
            fontSize = 15.sp,
            color = Color.Gray,
            modifier = Modifier
        )

        CustomTextField(
            value = pw,
            onValueChange = { pw = it },
            label = "비밀번호를 입력하세요"
        )

        CustomSpacer(10)

        // 비밀번호 확인
        Text(
            text = "비밀번호 확인",
            fontFamily = FontFamily(Font(R.font.pretendard_regular)),
            fontSize = 15.sp,
            color = Color.Gray,
            modifier = Modifier
        )

        CustomTextField(
            value = pw2,
            onValueChange = { pw2 = it },
            label = "비밀번호를 다시 입력하세요"
        )

        CustomSpacer(230)

        Button(
            onClick = {
                // 회원가입 조건 확인용 if문
                // 조건 : email 형식, pw 길이 8~12자, 비밀번호 == 비밀번호 확인
                if (pattern.matcher(email)
                        .matches() && pw.length >= 8 && pw.length < 12 && pw == pw2
                ) {
                    // putExtra로 email, password 전달
                    intent.putExtra("email", email)
                    intent.putExtra("password", pw)
                    context.startActivity(intent)
                    Toast.makeText(context, "회원가입에 성공했습니다", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "회원가입에 실패했습니다", Toast.LENGTH_SHORT).show()
                }
            },
            // 입력칸 3개 모두 채워지면 버튼 활성화
            enabled = if (email.isNotEmpty() && pw.isNotEmpty() && pw2.isNotEmpty()) true
            else false,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                "회원가입",
                color = Color.White,
                fontFamily = FontFamily(Font(R.font.pretendard_bold)),
                fontSize = 17.sp
            )
        }
    }

}


@Preview(showBackground = true)
@Composable
private fun SignupPreview() {
    LETSSOPTTheme {
        Signup()
    }
}
