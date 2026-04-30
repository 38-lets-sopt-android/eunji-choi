package com.example.letssopt

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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.letssopt.main.HomeViewModel
import com.example.letssopt.ui.theme.LETSSOPTColors

@Composable
fun CustomBottomBar (
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(),

    ){
    var selectedItem by remember { mutableStateOf(0) }
    val navController = rememberNavController()
    NavigationBar (
        containerColor = LETSSOPTColors.BackGround
    ) {
        viewModel.bottomIcons.forEachIndexed { index, barIcon ->
            NavigationBarItem(
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.Transparent,
                    selectedIconColor = LETSSOPTColors.White,
                    unselectedIconColor = LETSSOPTColors.Disabled,
                    selectedTextColor = LETSSOPTColors.White,
                    unselectedTextColor = LETSSOPTColors.Disabled
                ),
                selected = selectedItem == index,
                onClick = {
                    selectedItem = index
                    when (index) {
                        0 -> navController.navigate(Home)
                        1 -> navController.navigate(Purchase)
                        2 -> navController.navigate(Webtoon)
                        3 -> navController.navigate(Search)
                        4 -> navController.navigate(Storage)
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