package com.example.letssopt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.letssopt.ui.theme.LETSSOPTTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.viewmodel.compose.viewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LETSSOPTTheme {
                Main()
            }
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Main(modifier: Modifier = Modifier, viewModel: MainViewModel = viewModel()) {

    var selectedIndex by remember { mutableStateOf(0) }
    val navItems = listOf("메인", "개별 구매", "웹툰", "찾기", "보관함")

    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
                actions = {
                    viewModel.topIcons.forEach { iconRes ->
                        Image(
                            painter = painterResource(id = iconRes),
                            contentDescription = null,
                            modifier = Modifier
                                .size(30.dp)
                                .padding(4.dp)
                        )
                    }
                }
            )
        },

        bottomBar = {
            NavigationBar {
                navItems.forEachIndexed { index, label ->
                    NavigationBarItem(
                        selected = selectedIndex == index,
                        onClick = { selectedIndex = index },
                        icon = {},
                        label = { Text(text = label) }
                    )
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 15.dp)
        ) {
            when (selectedIndex) {
                0 -> MainScreen()
                1 -> PurchaseScreen()
                2 -> WebtoonScreen()
                3 -> SearchScreen()
                4 -> StorageScreen()
            }


        }
    }
}


@Preview(showBackground = true)
@Composable
private fun MainPreview() {
    LETSSOPTTheme {
        Main()
    }
}


