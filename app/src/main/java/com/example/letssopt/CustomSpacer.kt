package com.example.letssopt

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun CustomSpacer(dp:Int) {
    val modifier = null
    Spacer(modifier = Modifier.height(dp.dp))
}

@Composable
fun CustomTextField(
    value : String,
    onValueChange : (String) -> Unit,
    label : String){
    TextField(
        value = value,
        onValueChange = onValueChange,
        shape = RoundedCornerShape(16.dp),
        colors = TextFieldDefaults.colors(
            Color.DarkGray,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        textStyle = TextStyle(color = Color.LightGray),
        modifier = Modifier.fillMaxWidth(),
        label = {
            Text(
                text = label,
                fontFamily = FontFamily(Font(R.font.pretendard_regular)),
                fontSize = 15.sp,
                color = Color.LightGray
            )
        }
    )
}

