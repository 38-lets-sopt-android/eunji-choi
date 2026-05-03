package com.example.letssopt.home

import androidx.compose.runtime.Immutable

@Immutable
data class PartyItem(
    val imageRes: Int,
    val time: String,
    val title: String
)

