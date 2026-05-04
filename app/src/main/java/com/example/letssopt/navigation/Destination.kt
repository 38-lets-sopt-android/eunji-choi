package com.example.letssopt.navigation
import com.example.letssopt.navigation.MainTabRoute
import com.example.letssopt.navigation.Route
import kotlinx.serialization.Serializable


@Serializable object Home : MainTabRoute
@Serializable object Purchase : MainTabRoute
@Serializable object Webtoon : MainTabRoute
@Serializable object Search : MainTabRoute
@Serializable object Storage : MainTabRoute
@Serializable data object Login
@Serializable data object SignUp
@Serializable object HomeGraph