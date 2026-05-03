package com.example.letssopt.home.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.letssopt.component.HeightSpacer
import com.example.letssopt.home.HomeViewModel
import com.example.letssopt.home.sections.NewSection
import com.example.letssopt.home.sections.PartySection
import com.example.letssopt.home.sections.SoonSection
import com.example.letssopt.home.sections.DramaSection

// 각 탭 화면들 (함수 하나 = 화면 하나)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel()
) {

    LazyColumn (
        modifier = modifier
            .fillMaxSize()
    ){
        item {HeightSpacer(30.dp)}

        item{NewSection(contents = viewModel.getnewList())}

        item {HeightSpacer(20.dp)}

        item {DramaSection(contents = viewModel.getdramaList())}

        item {HeightSpacer(20.dp)}

        item {SoonSection(contents = viewModel.getsoonList())}

        item {HeightSpacer(20.dp)}

        item {PartySection(contents = viewModel.getpartyList())}

    }
}


@Preview
@Composable
private fun HomeScreenPreview() {
    HomeScreen()
}
