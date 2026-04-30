package com.example.letssopt.Home.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.letssopt.component.HeightSpacer
import com.example.letssopt.Home.HomeViewModel
import com.example.letssopt.Home.sections.New_section
import com.example.letssopt.Home.sections.Party_section
import com.example.letssopt.Home.sections.Soon_section
import com.example.letssopt.Home.sections.Drama_section

// 각 탭 화면들 (함수 하나 = 화면 하나)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel()
) {

    LazyColumn (
        modifier = modifier.fillMaxSize()
    ){
        item {HeightSpacer(30.dp)}

        item{New_section(contents = viewModel.newList, onContentClick = {})}

        item {HeightSpacer(20.dp)}

        item {Drama_section(contents = viewModel.dramaList, onContentClick = {})}

        item {HeightSpacer(20.dp)}

        item {Soon_section(contents = viewModel.soonList, onContentClick = {})}

        item {HeightSpacer(20.dp)}

        item {Party_section(contents = viewModel.partyList, onContentClick = {})}

    }
}


