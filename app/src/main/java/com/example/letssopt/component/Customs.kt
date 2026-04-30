package com.example.letssopt.component

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.letssopt.R
import com.example.letssopt.ui.theme.LETSSOPTColors
import com.example.letssopt.ui.theme.LETSSOPTTheme
import com.example.letssopt.ui.theme.LETSSOPTTypography
import com.example.letssopt.ui.theme.Typography


@Composable // Spacer(modifier.weight(f) 커스텀
fun ColumnScope.WeightSpacer(weight: Float, modifier: Modifier = Modifier) {
    Spacer(modifier = modifier.weight(weight))
}

@Composable // Spacer(modifier.height(dp) 커스텀
fun HeightSpacer(dp: Dp, modifier: Modifier = Modifier) {
    Spacer(modifier = modifier.height(dp))
}

@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        shape = RoundedCornerShape(16.dp),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = LETSSOPTColors.Surface,
            unfocusedContainerColor = LETSSOPTColors.Surface,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            unfocusedPlaceholderColor = LETSSOPTColors.placeholder,
            focusedPlaceholderColor = LETSSOPTColors.placeholder
        ),
        singleLine = true, // 텍스트 입력 2줄 방지
        keyboardOptions = keyboardOptions,
        visualTransformation = visualTransformation,
        placeholder = {
            Text(
                text = placeholder,
                style = Typography.caption
            )
        },
        modifier = modifier
            .fillMaxWidth()
    )
}

