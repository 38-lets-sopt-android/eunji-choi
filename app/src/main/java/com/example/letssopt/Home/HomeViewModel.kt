package com.example.letssopt.Home

import androidx.lifecycle.ViewModel
import com.example.letssopt.R

class HomeViewModel : ViewModel() {

    val newList = listOf(
        R.drawable.img_new_rilakkuma_pink,
        R.drawable.img_new_rilakkuma_yellow,
        R.drawable.img_new_rilakkuma_green
    )

    val dramaList = listOf(
        R.drawable.img_drama_kuromi,
        R.drawable.img_drama_sinamoroll,
        R.drawable.img_drama_kitty,
        R.drawable.img_drama_stitch,
        R.drawable.img_drama_pochacco
    )

    val soonList = listOf(
        R.drawable.img_soon_insideout2,
        R.drawable.img_soon_elemental,
        R.drawable.img_soon_zzotopia,
        R.drawable.img_soon_mu,
        R.drawable.img_soon_toystory
    )

    val partyList = listOf(
        PartyItem(R.drawable.img_party_angel, "오늘 21:13에 시작", "# 천사 가나디"),
        PartyItem(R.drawable.img_party_devil, "오늘 22:00에 시작", "# 악마 가나디"),
    )

    val topIcons = listOf(
        R.drawable.ic_top_bar_video,
        R.drawable.ic_top_bar_bell,
        R.drawable.ic_top_bar_profile,
        )

    val bottomIcons = listOf(
        BottomBarItem("메인", R.drawable.ic_bottom_bar_main),
        BottomBarItem("개별 구매", R.drawable.ic_bottom_bar_category),
        BottomBarItem("웹툰", R.drawable.ic_bottom_bar_folder),
        BottomBarItem("찾기", R.drawable.ic_bottom_bar_search),
        BottomBarItem("보관함", R.drawable.ic_bottom_bar_wallet),
    )
}