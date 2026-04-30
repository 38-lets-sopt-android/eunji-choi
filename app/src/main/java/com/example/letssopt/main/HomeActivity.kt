//package com.example.letssopt.main
//
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.Icon
//import androidx.compose.material3.NavigationBar
//import androidx.compose.material3.NavigationBarItem
//import androidx.compose.material3.NavigationBarItemDefaults
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Text
//import androidx.compose.material3.TopAppBar
//import androidx.compose.material3.TopAppBarDefaults
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.vector.ImageVector
//import androidx.compose.ui.res.vectorResource
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.lifecycle.viewmodel.compose.viewModel
//import androidx.navigation.compose.rememberNavController
//import com.example.letssopt.ui.theme.LETSSOPTColors
//import com.example.letssopt.ui.theme.LETSSOPTTheme
//import kotlinx.serialization.Serializable
//
//
//
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun Home2(modifier: Modifier = Modifier, viewModel: HomeViewModel = viewModel()) {
//    val navController = rememberNavController()
//    var selectedItem by remember { mutableStateOf(0) }
//
//    Scaffold(
//        topBar = {
//            TopAppBar(
//                title = {},
//                colors = TopAppBarDefaults.topAppBarColors(
//                    containerColor = LETSSOPTColors.BackGround
//                ),
//                actions = {
//                    viewModel.topIcons.forEach { topIcon ->
//                        Icon(
//                            imageVector = ImageVector.vectorResource(id = topIcon),
//                            contentDescription = null,
//                            modifier = Modifier.padding(horizontal = 7.dp)
//                        )
//                    }
//                }
//            )
//        },
//
//        bottomBar = {
//            NavigationBar (
//                containerColor = LETSSOPTColors.BackGround
//            ){
//                viewModel.bottomIcons.forEachIndexed { index, barIcon ->
//                    NavigationBarItem(
//                        colors = NavigationBarItemDefaults.colors(
//                            indicatorColor = Color.Transparent,
//                            selectedIconColor = LETSSOPTColors.White,
//                            unselectedIconColor = LETSSOPTColors.Disabled,
//                            selectedTextColor = LETSSOPTColors.White,
//                            unselectedTextColor = LETSSOPTColors.Disabled
//                        ),
//                        selected = selectedItem == index,
//                        onClick = {
//                            selectedItem = index
//
//                        },
//                        icon = {
//                            Icon(
//                                imageVector = ImageVector.vectorResource(id = barIcon.icon),
//                                contentDescription = null
//                            )
//                        },
//                        label = {
//                            Text(
//                                text = barIcon.label
//                            )
//                        }
//                    )
//                }
//            }
//        }
//    ) { innerPadding ->
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(innerPadding)
//                .padding(horizontal = 15.dp)
//        ) {
//            NavGraph(viewModel = viewModel, navController = navController)
//        }
//    }
//}
//
//
//@Preview(showBackground = true)
//@Composable
//private fun MainPreview() {
//    LETSSOPTTheme {
//        Home()
//    }
//}
//
//
