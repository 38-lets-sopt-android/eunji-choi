package com.example.letssopt.component

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.letssopt.navigation.Home
import com.example.letssopt.navigation.Purchase
import com.example.letssopt.navigation.Search
import com.example.letssopt.navigation.Storage
import com.example.letssopt.navigation.Webtoon
import com.example.letssopt.home.HomeViewModel
import com.example.letssopt.ui.theme.LETSSOPTColors

@Composable
fun CustomBottomBar (
    tabs: List<BottomIcons>,
    currentTab: BottomIcons?,
    onTabSelected: (BottomIcons) -> Unit,
    modifier: Modifier = Modifier
    ){
    NavigationBar (
        modifier = modifier,
        containerColor = LETSSOPTColors.BackGround
    ) {
        tabs.forEach { tab ->
            key(tab.route) {
                NavigationBarItem(
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = Color.Transparent,
                        selectedIconColor = LETSSOPTColors.White,
                        unselectedIconColor = LETSSOPTColors.Disabled,
                        selectedTextColor = LETSSOPTColors.White,
                        unselectedTextColor = LETSSOPTColors.Disabled
                    ),
                    selected = (tab == currentTab),
                    icon = {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = tab.iconRes),
                            contentDescription = null
                        )
                    },
                    label = {
                        Text(
                            text = tab.label
                        )
                    },
                    onClick = { onTabSelected(tab) }
                )
            }
        }
    }
}


@Preview
@Composable
private fun CustomBottomBarPreview() {
    val navController = rememberNavController()
//    CustomBottomBar(
//        navController = navController
//    )
}