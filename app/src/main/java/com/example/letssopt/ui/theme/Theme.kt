package com.example.letssopt.ui.theme


import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

private val LETSSOPTColorScheme = darkColorScheme(
    primary = LETSSOPTColors.Primary_Red,
    background = LETSSOPTColors.BackGround,
    surface = LETSSOPTColors.Surface,
    onPrimary = LETSSOPTColors.White,
    onBackground = LETSSOPTColors.White,
    onSurface = LETSSOPTColors.White
)

@Composable
fun LETSSOPTTheme(
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalLETSSOPTTypography provides Typography
    ) {
        MaterialTheme(
            colorScheme = LETSSOPTColorScheme,
            content = content
        )
    }
}