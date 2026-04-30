package com.example.letssopt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import com.example.letssopt.component.CustomBottomBar
import com.example.letssopt.component.CustomTopBar
import com.example.letssopt.login.LoginScreen
import com.example.letssopt.Home.screens.HomeScreen
import com.example.letssopt.Home.screens.PurchaseScreen
import com.example.letssopt.Home.screens.SearchScreen
import com.example.letssopt.Home.screens.StorageScreen
import com.example.letssopt.Home.screens.WebtoonScreen
import com.example.letssopt.navigation.Home
import com.example.letssopt.navigation.HomeGraph
import com.example.letssopt.navigation.Login
import com.example.letssopt.navigation.Purchase
import com.example.letssopt.navigation.Search
import com.example.letssopt.navigation.SignUp
import com.example.letssopt.navigation.Storage
import com.example.letssopt.navigation.Webtoon
import com.example.letssopt.AutoViewModel
import com.example.letssopt.signup.SignUpScreen
import com.example.letssopt.ui.theme.LETSSOPTTheme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LETSSOPTTheme {
                val autoViewModel: AutoViewModel = viewModel()

                val navController = rememberNavController()

                val currentDestination =
                    navController.currentBackStackEntryAsState().value?.destination

                val isInHome = currentDestination?.hierarchy?.any {
                    it.route == HomeGraph::class.qualifiedName
                } == true

                Scaffold(
                    modifier = Modifier
                        .fillMaxSize(),

                    topBar = { if (isInHome) CustomTopBar() },
                    bottomBar = { if (isInHome) CustomBottomBar() }
                ) { innerPadding ->
                    NavHost(
                        modifier = Modifier.padding(innerPadding),
                        navController = navController,
                        startDestination = autoViewModel.startDestination,
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
                            LoginScreen(
                                viewModel = autoViewModel,
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
                            SignUpScreen(
                                viewModel = autoViewModel,
                                navigateToLogin = {
                                    navController.navigate(Login) {
                                        popUpTo<SignUp> { inclusive = true }
                                    }
                                }
                            )
                        }

                        navigation<HomeGraph>(startDestination = Home) {
                            composable<Home> { HomeScreen() }
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