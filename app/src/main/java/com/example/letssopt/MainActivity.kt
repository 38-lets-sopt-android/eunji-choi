package com.example.letssopt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.letssopt.component.BottomIcons
import com.example.letssopt.component.CustomBottomBar
import com.example.letssopt.component.CustomTopBar
import com.example.letssopt.home.HomeViewModel
import com.example.letssopt.home.screens.HomeScreen
import com.example.letssopt.home.screens.PurchaseScreen
import com.example.letssopt.home.screens.SearchScreen
import com.example.letssopt.home.screens.StorageScreen
import com.example.letssopt.home.screens.WebtoonScreen
import com.example.letssopt.login.LoginRoute
import com.example.letssopt.navigation.Home
import com.example.letssopt.navigation.HomeGraph
import com.example.letssopt.navigation.Login
import com.example.letssopt.navigation.Purchase
import com.example.letssopt.navigation.Search
import com.example.letssopt.navigation.SignUp
import com.example.letssopt.navigation.Storage
import com.example.letssopt.navigation.Webtoon
import com.example.letssopt.signup.SignUpRoute
import com.example.letssopt.ui.theme.LETSSOPTTheme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LETSSOPTTheme {
                val startDestination = if (SaveInfo.prefs.getBoolean("Is_Logged_In", false)) HomeGraph else Login

                val navController = rememberNavController()

                val currentDestination =
                    navController.currentBackStackEntryAsState().value?.destination

                val isInHome = currentDestination?.hierarchy?.any {
                    it.route == HomeGraph::class.qualifiedName
                } == true

                Scaffold(
                    modifier = Modifier
                        .fillMaxSize(),
                    topBar = { if (isInHome) {
                        val homeViewModel: HomeViewModel = viewModel()
                        CustomTopBar(
                            icons = homeViewModel.topIcons // 여기서 꺼내서 전달
                        )
                    } },
                    bottomBar = { if (isInHome) {
                        val tabs = BottomIcons.entries
                        val currentTab = tabs.find {
                            currentDestination?.hierarchy?.any { dest ->
                                dest.route == it.route::class.qualifiedName
                            } == true
                        }
                        CustomBottomBar(
                            tabs = tabs,
                            currentTab = currentTab,
                            onTabSelected = { tab ->
                                navController.navigate(tab.route){
                                    popUpTo(Home){inclusive = false}
                                    launchSingleTop = true
                                }
                            }
                        )
                    } }
                ) { innerPadding ->
                    NavHost(
                        modifier = Modifier.padding(innerPadding),
                        navController = navController,
                        startDestination = startDestination,
                        enterTransition = {
                            slideInHorizontally(
                                initialOffsetX = { fullWidth -> fullWidth },
                                animationSpec = tween(durationMillis = 300)
                            )
                        },
                        exitTransition = {
                            slideOutHorizontally(
                                targetOffsetX = { fullWidth -> -fullWidth },
                                animationSpec = tween(durationMillis = 300)
                            )
                        },
                        popEnterTransition = {
                            slideInHorizontally(
                                initialOffsetX = { fullWidth -> -fullWidth },
                                animationSpec = tween(durationMillis = 300)
                            )
                        },
                        popExitTransition = {
                            slideOutHorizontally(
                                targetOffsetX = { fullWidth -> fullWidth },
                                animationSpec = tween(durationMillis = 300)
                            )
                        },
                    ) {
                        composable<Login> {
                            LoginRoute(
                                navigateToHome = {
                                    navController.navigate(Home) {
                                        popUpTo<Login> { inclusive = true }
                                    }
                                },
                                navigateToSignUp = {
                                    navController.navigate(SignUp)
                                }
                            )
                        }

                        composable<SignUp> {
                            SignUpRoute {
                                navController.navigate(Login) {
                                    popUpTo<SignUp> { inclusive = true }
                                }
                            }
                        }

                        navigation<HomeGraph>(startDestination = Home) {
                            composable<Home> { HomeScreen(modifier = Modifier) }
                            composable<Purchase> { PurchaseScreen() }
                            composable<Webtoon> { WebtoonScreen() }
                            composable<Search> { SearchScreen() }
                            composable<Storage> { StorageScreen() }
                        }
                    }
                }
            }
        }
    }
}