package com.example.letssopt.component

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.letssopt.Home.HomeViewModel
import com.example.letssopt.ui.theme.LETSSOPTColors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopBar(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel()
) {
    TopAppBar(
        modifier = modifier,
        title = {},
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = LETSSOPTColors.BackGround
        ),
        actions = {
            viewModel.topIcons.forEach { topIcon ->
                Icon(
                    imageVector = ImageVector.vectorResource(id = topIcon),
                    contentDescription = null,
                    modifier = Modifier.padding(horizontal = 7.dp)
                )
            }
        }
    )
}