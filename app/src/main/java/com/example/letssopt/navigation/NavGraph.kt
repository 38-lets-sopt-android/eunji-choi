package com.example.letssopt.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.letssopt.main.MainViewModel
import com.example.letssopt.main.Screens.HomeScreen
import com.example.letssopt.main.Screens.PurchaseScreen
import com.example.letssopt.main.Screens.SearchScreen
import com.example.letssopt.main.Screens.StorageScreen
import com.example.letssopt.main.Screens.WebtoonScreen


@Composable
fun NavGraph(
    viewModel: MainViewModel,
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Home
    ) {
        composable<Home> { HomeScreen(viewModel = viewModel) }
        composable<Purchase> { PurchaseScreen() }
        composable<Webtoon> { WebtoonScreen() }
        composable<Search> { SearchScreen() }
        composable<Storage> { StorageScreen() }
    }
}

