package com.example.letssopt.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.letssopt.ui.theme.LETSSOPTColors
import com.example.letssopt.ui.theme.Typography

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

@Preview
@Composable
private fun CustomTextFieldPreview() {
    CustomTextField(
        value = "테스트",
        onValueChange = {},
        placeholder = "입력하세요"
    )
}