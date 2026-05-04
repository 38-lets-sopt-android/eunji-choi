package com.example.letssopt.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.letssopt.home.HomeViewModel
import com.example.letssopt.ui.theme.LETSSOPTColors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopBar(
    modifier: Modifier = Modifier,
    icons : List<Int>
) {
    TopAppBar(
        modifier = modifier,
        title = {},
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = LETSSOPTColors.BackGround
        ),
        actions = {
            icons.forEach { topIcon ->
                Icon(
                    imageVector = ImageVector.vectorResource(id = topIcon),
                    contentDescription = null,
                    modifier = Modifier.padding(horizontal = 7.dp)
                )
            }
        }
    )
}

@Preview
@Composable
private fun CustomTopBarPreview() {
//    CustomTopBar()
}