package com.example.letssopt.component

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp


@Composable // Spacer(modifier.weight(f) 커스텀
fun ColumnScope.WeightSpacer(weight: Float, modifier: Modifier = Modifier) {
    Spacer(modifier = modifier.weight(weight))
}

@Composable // Spacer(modifier.height(dp) 커스텀
fun HeightSpacer(dp: Dp, modifier: Modifier = Modifier) {
    Spacer(modifier = modifier.height(dp))
}

