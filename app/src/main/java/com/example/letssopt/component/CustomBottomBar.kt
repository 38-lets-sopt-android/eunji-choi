package com.example.letssopt.component

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.letssopt.navigation.Home
import com.example.letssopt.navigation.Purchase
import com.example.letssopt.navigation.Search
import com.example.letssopt.navigation.Storage
import com.example.letssopt.navigation.Webtoon
import com.example.letssopt.Home.HomeViewModel
import com.example.letssopt.navigation.HomeGraph
import com.example.letssopt.ui.theme.LETSSOPTColors

@Composable
fun CustomBottomBar (
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(),
    navController: NavController
    ){
    NavigationBar (
        modifier = modifier,
        containerColor = LETSSOPTColors.BackGround
    ) {
        val currentDestination = navController.currentBackStackEntryAsState().value?.destination

        viewModel.bottomIcons.forEachIndexed { index, barIcon ->

            val selected = currentDestination?.route == barIcon.destination::class.qualifiedName

            NavigationBarItem(
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.Transparent,
                    selectedIconColor = LETSSOPTColors.White,
                    unselectedIconColor = LETSSOPTColors.Disabled,
                    selectedTextColor = LETSSOPTColors.White,
                    unselectedTextColor = LETSSOPTColors.Disabled
                ),
                selected = selected,
                onClick = {
                    val destination = when (index) {
                        0 -> Home
                        1 -> Purchase
                        2 -> Webtoon
                        3 -> Search
                        4 -> Storage
                        else -> Home
                    }
                    navController.navigate(destination) {
                        // 한 번 뒤로가기 누르면 HomeScreen으로 이동
                        popUpTo<Home> { inclusive = false }
                        // 한 번 더 누르면 앱 밖으로!
                        launchSingleTop = true
                    }
                },
                icon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = barIcon.icon),
                        contentDescription = null
                    )
                },
                label = {
                    Text(
                        text = barIcon.label
                    )
                }
            )
        }
    }
}