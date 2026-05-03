package com.example.letssopt.component

import androidx.annotation.DrawableRes
import com.example.letssopt.R
import com.example.letssopt.navigation.MainTabRoute
import com.example.letssopt.navigation.Home
import com.example.letssopt.navigation.Purchase
import com.example.letssopt.navigation.Search
import com.example.letssopt.navigation.Storage
import com.example.letssopt.navigation.Webtoon

enum class BottomIcons (
    val label: String,
    @DrawableRes val iconRes: Int,
    val route : MainTabRoute
){
    HOME(
        label = "메인",
        iconRes = R.drawable.ic_bottom_bar_main,
        route = Home
    ),
    PURCHASE(
        label = "개별구매",
        iconRes = R.drawable.ic_bottom_bar_purchase,
        route = Purchase
    ),
    WEBTOON(
        label = "웹툰",
        iconRes = R.drawable.ic_bottom_bar_webtoon,
        route = Webtoon
    ),
    SEARCH(
        label = "찾기",
        iconRes = R.drawable.ic_bottom_bar_search,
        route = Search
    ),
    STORAGE(
        label = "보관함",
        iconRes = R.drawable.ic_bottom_bar_storage,
        route = Storage
    )
}
