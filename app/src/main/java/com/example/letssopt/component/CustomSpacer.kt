package com.example.letssopt.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.letssopt.R


// Spacer(modifier.height(dp.dp) 커스텀
//@Composable
//fun CustomSpacer(dp:Int) {
//    Spacer(modifier = Modifier.height(dp.dp))
//}


@Composable // Spacer(modifier.weight(1f) 커스텀
fun ColumnScope.WeightSpacer(weight: Float, modifier: Modifier = Modifier) {
    Spacer(modifier = modifier.weight(weight))
}

@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None
) {
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
        singleLine = true, // 텍스트 입력 2줄 방지
        keyboardOptions = keyboardOptions,
        visualTransformation = visualTransformation,
        placeholder = {
            Text(
                text = label,
                fontFamily = FontFamily(Font(R.font.pretendard_regular)),
                fontSize = 15.sp,
                color = Color.LightGray
            )
        },
        modifier = Modifier
            .fillMaxWidth()
    )
}

@Composable
fun Modifier.noRippleClickable(onClick: () -> Unit, enabled : Boolean): Modifier = composed {
    clickable(
        indication = null,
        interactionSource = remember { MutableInteractionSource()},
        onClick = onClick,
        enabled = enabled
    )
}