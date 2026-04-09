package com.example.letssopt

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.letssopt.ui.theme.LETSSOPTTheme

class LoginActivity : ComponentActivity() { //로그인 화면 activity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val email = intent.getStringExtra("email")
        val pw = intent.getStringExtra("password")
        enableEdgeToEdge()
        setContent {
            LETSSOPTTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Login(
                        // 처음 앱 실행하고 로그인 버튼 클릭 시 바로 창 넘어가는 오류 해결하려고 임의값 부여
                        email = email ?: "email",
                        pw = pw ?: "pw",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Login(email: String, pw: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val intent = Intent(context, SignUpActivity::class.java)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(horizontal = 16.dp)
    )

    {
        Spacer(modifier = Modifier.height(80.dp))
        Text(
            text = "watcha",
            color = Color.Red,
            fontSize = 40.sp,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily(Font(R.font.pretendard_bold)),
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "이메일로 로그인",
            fontFamily = FontFamily(Font(R.font.pretendard_bold)),
            fontSize = 20.sp,
            color = Color.White,
            modifier = Modifier
        )
        Spacer(modifier = Modifier.height(30.dp))

        // 이메일 입력
        Text(
            text = "이메일",
            fontFamily = FontFamily(Font(R.font.pretendard_regular)),
            fontSize = 15.sp,
            color = Color.Gray,
            modifier = Modifier
        )
        var emailinput by remember { mutableStateOf("") }
        TextField(
            value = emailinput,
            onValueChange = { emailinput = it },
            colors = TextFieldDefaults.colors(
                Color.DarkGray,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            textStyle = TextStyle(color = Color.LightGray),
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .fillMaxWidth(),
            label = {
                Text(
                    text = "이메일 주소를 입력하세요",
                    fontFamily = FontFamily(Font(R.font.pretendard_regular)),
                    fontSize = 15.sp,
                    color = Color.LightGray
                )
            }
        )
        Spacer(modifier = Modifier.height(10.dp))

        // 비밀번호 입력
        Text(
            text = "비밀번호",
            fontFamily = FontFamily(Font(R.font.pretendard_regular)),
            fontSize = 15.sp,
            color = Color.Gray,
            modifier = Modifier
        )
        var pwinput by remember { mutableStateOf("") }
        TextField(
            value = pwinput,
            onValueChange = { pwinput = it },
            shape = RoundedCornerShape(16.dp),
            colors = TextFieldDefaults.colors(
                Color.DarkGray,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            textStyle = TextStyle(color = Color.LightGray),
            modifier = Modifier
                .fillMaxWidth(),
            // 비밀번호 입력 가리기
            visualTransformation = PasswordVisualTransformation(),
            label = {
                Text(
                    text = "비밀번호를 입력하세요",
                    fontFamily = FontFamily(Font(R.font.pretendard_regular)),
                    fontSize = 15.sp,
                    color = Color.LightGray
                )
            }
        )
        Spacer(modifier = Modifier.height(320.dp))

        // text 2개 가로로 나열하기 위해 Row에 만듦
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center

        ) {
            Text(
                text = "아직 계정이 없으신가요?",
                color = Color.Gray,
                fontFamily = FontFamily(Font(R.font.pretendard_regular)),
                fontSize = 15.sp,
                modifier = Modifier
                    .padding(7.dp)
            )

            // 회원가입 글자만 click 가능하게끔 '회원가입' text 생성!
            Text(
                text = "회원가입",
                color = Color.Gray,
                fontFamily = FontFamily(Font(R.font.pretendard_regular)),
                fontSize = 15.sp,
                modifier = Modifier
                    .padding(3.dp)
                    .clickable(
                        onClick = {
                            context.startActivity(intent)
                        }
                    )
            )
        }

        Button(
            onClick = {
                // email, pw가 같다는 조건 만족할 때만 'MainActivity'로 이동!
                if (emailinput == email && pwinput == pw) {
                    val intent3 = Intent(context, MainActivity::class.java)
                    context.startActivity(intent3)
                    Toast.makeText(context, "로그인에 성공했습니다", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "로그인에 실패했습니다", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
            shape = RoundedCornerShape(8.dp),
        ) {
            Text(
                "로그인", color = Color.White,
                fontFamily = FontFamily(Font(R.font.pretendard_bold)),
                fontSize = 17.sp
            )
        }

    }

}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    LETSSOPTTheme {
        Login("email", "pw")
    }
}