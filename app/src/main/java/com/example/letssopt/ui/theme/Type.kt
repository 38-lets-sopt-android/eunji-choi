package com.example.letssopt.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.letssopt.R

data class LETSSOPTTypography(
    val logo: TextStyle,
    val h1: TextStyle,
    val h2: TextStyle,
    val h3: TextStyle,
    val sh1: TextStyle,
    val sh3: TextStyle,
    val body: TextStyle,
    val body2: TextStyle,
    val body3: TextStyle,
    val body4: TextStyle,
    val caption: TextStyle,
    val caption2: TextStyle
)

private val pretendardFontFamily = FontFamily(
    Font(R.font.pretendard_regular, weight = FontWeight.Normal),
    Font(R.font.pretendard_bold, weight = FontWeight.Bold),
    Font(R.font.pretendard_bold, weight = FontWeight.W700),
    Font(R.font.pretendard_semibold, weight = FontWeight.W600),
    Font(R.font.pretendard_medium, weight = FontWeight.W500),
    Font(R.font.pretendard_light, weight = FontWeight.W300)
)

private val L1 = TextStyle(
    fontFamily = pretendardFontFamily,
    fontWeight = FontWeight.Bold,
    fontSize = 36.sp
)

private val H1 = TextStyle(
    fontFamily = pretendardFontFamily,
    fontWeight = FontWeight.Bold,
    fontSize = 24.sp
)

private val H2 = TextStyle(
    fontFamily = pretendardFontFamily,
    fontWeight = FontWeight.Bold,
    fontSize = 20.sp
)

private val H3 = TextStyle(
    fontFamily = pretendardFontFamily,
    fontWeight = FontWeight.W600,
    fontSize = 20.sp
)

private val SH1 = TextStyle(
    fontFamily = pretendardFontFamily,
    fontWeight = FontWeight.W600,
    fontSize = 18.sp
)

private val SH3 = TextStyle(
    fontFamily = pretendardFontFamily,
    fontWeight = FontWeight.W600,
    fontSize = 12.sp
)

private val Body = TextStyle(
    fontFamily = pretendardFontFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 16.sp
)

private val Body2 = TextStyle(
    fontFamily = pretendardFontFamily,
    fontWeight = FontWeight.W500,
    fontSize = 12.sp
)

private val Body3 = TextStyle(
    fontFamily = pretendardFontFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 12.sp
)

private val Body4 = TextStyle(
    fontFamily = pretendardFontFamily,
    fontWeight = FontWeight.W700,
    fontSize = 16.sp
)

private val Caption = TextStyle(
    fontFamily = pretendardFontFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 14.sp
)

private val Caption2 = TextStyle(
    fontFamily = pretendardFontFamily,
    fontWeight = FontWeight.W300,
    fontSize = 12.sp
)

val Typography = LETSSOPTTypography(
    logo = L1,
    h1 = H1,
    h2 = H2,
    h3 = H3,
    body = Body,
    body2 = Body2,
    body3 = Body3,
    body4 = Body4,
    caption = Caption,
    caption2 = Caption2,
    sh1 = SH1,
    sh3 = SH3
)

val LocalLETSSOPTTypography = staticCompositionLocalOf {
    Typography
}