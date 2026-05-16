package com.example.letssopt.home

import androidx.annotation.DrawableRes


data class StorageItemModel(
    val id: Int,
    val title: String,
    @DrawableRes val image: Int
)