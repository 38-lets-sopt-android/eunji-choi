package com.example.letssopt.home

import androidx.lifecycle.ViewModel
import com.example.letssopt.R
import com.example.letssopt.navigation.Home
import com.example.letssopt.navigation.Purchase
import com.example.letssopt.navigation.Search
import com.example.letssopt.navigation.Storage
import com.example.letssopt.navigation.Webtoon

class HomeViewModel : ViewModel() {

    val newList = listOf(
        R.drawable.img_new_rilakkuma_pink,
        R.drawable.img_new_rilakkuma_yellow,
        R.drawable.img_new_rilakkuma_green
    )

    // 쫀틀린에서 배운 문법!ㅎㅎ
    // 함수 본문이 단일 표현식일 때 = 으로 줄일 수 있음~
    fun getnewList() = newList

    val dramaList = listOf(
        R.drawable.img_drama_kuromi,
        R.drawable.img_drama_sinamoroll,
        R.drawable.img_drama_kitty,
        R.drawable.img_drama_stitch,
        R.drawable.img_drama_pochacco
    )

    fun getdramaList() = dramaList

    val soonList = listOf(
        R.drawable.img_soon_insideout2,
        R.drawable.img_soon_elemental,
        R.drawable.img_soon_zzotopia,
        R.drawable.img_soon_mu,
        R.drawable.img_soon_toystory
    )

    fun getsoonList() = soonList

    val partyList = listOf(
        PartyItem(R.drawable.img_party_angel, "오늘 21:13에 시작", "# 천사 가나디"),
        PartyItem(R.drawable.img_party_devil, "오늘 22:00에 시작", "# 악마 가나디"),
    )

    fun getpartyList() = partyList

    val topIcons = listOf(
        R.drawable.ic_top_bar_video,
        R.drawable.ic_top_bar_bell,
        R.drawable.ic_top_bar_profile,
        )

    fun gettopIcons() = topIcons

    val bottomIcons = listOf(
        BottomBarItem("메인", R.drawable.ic_bottom_bar_main, Home),
        BottomBarItem("개별 구매", R.drawable.ic_bottom_bar_purchase, Purchase),
        BottomBarItem("웹툰", R.drawable.ic_bottom_bar_webtoon, Webtoon),
        BottomBarItem("찾기", R.drawable.ic_bottom_bar_search, Search),
        BottomBarItem("보관함", R.drawable.ic_bottom_bar_storage, Storage),
    )

    fun getbottomIcons() = bottomIcons
}