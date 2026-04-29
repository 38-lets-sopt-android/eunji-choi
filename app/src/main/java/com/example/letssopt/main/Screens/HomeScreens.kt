package com.example.letssopt.main.Screens

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.letssopt.main.MainViewModel
import com.example.letssopt.main.Sections.New_section
import com.example.letssopt.main.Sections.Party_section
import com.example.letssopt.main.Sections.Soon_section
import com.example.letssopt.main.Sections.Drama_section

// 각 탭 화면들 (함수 하나 = 화면 하나)
@Composable
fun HomeScreen(
    viewModel: MainViewModel,
    modifier: Modifier = Modifier
) {
    LazyColumn (
        modifier = modifier.fillMaxSize()
    ){
        item {Spacer(modifier = Modifier.height(30.dp))}

        item{New_section(contents = viewModel.newList, onContentClick = {})}

        item {Spacer(modifier = Modifier.height(20.dp))}

        item {Drama_section(contents = viewModel.dramaList, onContentClick = {})}

        item {Spacer(modifier = Modifier.height(20.dp))}

        item {Soon_section(contents = viewModel.soonList, onContentClick = {})}

        item {Spacer(modifier = Modifier.height(20.dp))}

        item {Party_section(contents = viewModel.partyList, onContentClick = {})}

    }
}


