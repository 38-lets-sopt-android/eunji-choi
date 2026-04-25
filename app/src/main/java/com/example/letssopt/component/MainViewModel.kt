package com.example.letssopt.component

import androidx.lifecycle.ViewModel
import com.example.letssopt.R

data class DramaItem(
    val imageRes: Int,
    val time: String,
    val title: String
)

class MainViewModel : ViewModel() {

    val newList = listOf(
        R.drawable.new1,
        R.drawable.new2,
        R.drawable.new3
    )

    val dramaList = listOf(
        R.drawable.drama1,
        R.drawable.drama2,
        R.drawable.drama3,
        R.drawable.drama4,
        R.drawable.drama5
    )

    val soonList = listOf(
        R.drawable.soon1,
        R.drawable.soon2,
        R.drawable.soon3,
        R.drawable.soon4,
        R.drawable.soon5
    )

    val partyList = listOf(
        DramaItem(R.drawable.party1, "오늘 21:13에 시작", "# 천사 가나디"),
        DramaItem(R.drawable.party2, "오늘 22:00에 시작", "# 악마 가나디"),
    )

    val topIcons = listOf(
        R.drawable.icon_video,
        R.drawable.icon_bell,
        R.drawable.icon_person
    )
}