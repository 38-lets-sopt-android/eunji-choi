package com.example.letssopt

import android.content.Intent
import android.os.Bundle
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
import androidx.compose.runtime.LongState
import androidx.compose.runtime.Recomposer
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.example.letssopt.ui.theme.LETSSOPTTheme


class SignUpActivity : ComponentActivity() {

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
    val intent = Intent(context, MainActivity::class.java)
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
            text = "회원가입",
            modifier = modifier
        )
        Text(
            text = "이메일",
            modifier = modifier
        )

        var email by remember {mutableStateOf("")}
        TextField(
            value = email,
            onValueChange = { email = it },
            modifier = Modifier
                .fillMaxWidth(),
            label = { Text("이메일 주소를 입력하세요") }
        )

        Text(
            text = "비밀번호",
            modifier = modifier
        )
        var pw by remember {mutableStateOf("")}
        TextField(
            value = pw,
            onValueChange = { pw = it },
            modifier = Modifier
                .fillMaxWidth(),
            label = { Text(text = "비밀번호를 입력하세요") }
        )
        Text(
            text = "비밀번호 확인",
            modifier = modifier
        )
        TextField(
            value = "",
            onValueChange = { },
            modifier = Modifier
                .fillMaxWidth(),
            label = { Text(text = "비밀번호를 다시 입력하세요") }
        )
        Button(
            onClick = {
                intent.putExtra("email",email)
                intent.putExtra("password",pw)
                context.startActivity(intent)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text("회원가입", color = Color.White)
        }
    }

}


@Preview(showBackground = true)
@Composable
fun SignupPreview() {
    LETSSOPTTheme {
        Signup()
    }}
