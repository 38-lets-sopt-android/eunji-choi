package com.example.letssopt.Home

import androidx.compose.runtime.Immutable

@Immutable
data class PartyItem(
    val imageRes: Int,
    val time: String,
    val title: String
)

@Immutable
data class BottomBarItem(
    val label: String,
    val icon: Int
)