package com.example.letssopt

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.letssopt.ui.theme.LETSSOPTTheme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val email = intent.getStringExtra("email")
        val pw = intent.getStringExtra("password")
        enableEdgeToEdge()
        setContent {
            LETSSOPTTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Login(
                        email = email ?: "",
                        pw = pw ?: "",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Login(email: String,pw: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val intent = Intent(context, SignUpActivity::class.java)

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 15.dp))
    {
        Text(
            text = "Watcha",
            textAlign = TextAlign.Center,
            fontFamily = FontFamily(Font(R.font.pretendard_bold)),
            fontWeight = FontWeight.Bold,
            modifier = modifier
        )
        Text(
            text = "이메일로 로그인",
            modifier = modifier
        )
        Text(
            text = "이메일",
            modifier = modifier
        )
        var emailinput by remember {mutableStateOf("")}
        TextField(
            value = emailinput,
            onValueChange = { emailinput = it },
            modifier = Modifier
                .fillMaxWidth(),
            label = { Text(text = "이메일 주소를 입력하세요") }
        )
        Text(
            text = "비밀번호",
            modifier = modifier
        )
        var pwinput by remember {mutableStateOf("")}
        var showPassword by remember { mutableStateOf(false) }
        TextField(
            value = pwinput,
            onValueChange = { pwinput =it },
            modifier = Modifier
                .fillMaxWidth(),
            visualTransformation = if (showPassword) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            },
            label = { Text(text = "비밀번호를 입력하세요") }
        )
        Text(
            text = "아직 계정이 없으신가요?",
            modifier = modifier
        )
        Button(
            onClick = {
                context.startActivity(intent)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            Text("회원가입", color = Color.White)
        }
        Button(
            onClick = {
                if (emailinput == email && pwinput == pw){
                    val intent3 = Intent(context, MainActivity::class.java)
                    context.startActivity(intent3)
                    Toast.makeText(context, "로그인에 성공했습니다", Toast.LENGTH_SHORT).show()
                }
                else {
                    Toast.makeText(context, "로그인에 실패했습니다", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text("로그인", color = Color.White)
        }

    }

}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    LETSSOPTTheme {
        Login("email","pw")
    }
}