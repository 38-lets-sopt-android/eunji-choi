package com.example.letssopt.signup

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.letssopt.component.CustomTextField
import com.example.letssopt.ui.theme.LETSSOPTColors
import com.example.letssopt.ui.theme.Typography

@Composable
fun SignUpTextField(
    modifier: Modifier = Modifier,
    text: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    value: String,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
) {
    Text(
        text = text,
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 3.dp),
        style = Typography.caption,
        color = LETSSOPTColors.Text_Secondary
    )

    CustomTextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        placeholder = placeholder,
        keyboardOptions = keyboardOptions
    )
}