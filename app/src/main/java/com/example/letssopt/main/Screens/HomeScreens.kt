package com.example.letssopt.main.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import com.example.letssopt.R
import com.example.letssopt.main.MainViewModel
import com.example.letssopt.main.Sections.drama_section
import com.example.letssopt.main.Sections.new_section
import com.example.letssopt.main.Sections.party_section
import com.example.letssopt.main.Sections.soon_section
import com.example.letssopt.main.Sections.whatgorism_section

// 각 탭 화면들 (함수 하나 = 화면 하나)
@Composable
fun HomeScreen(
    viewModel: MainViewModel
) {
    LazyColumn {
        item {Spacer(modifier = Modifier.height(30.dp))}

        item{new_section(contents = viewModel.newList, onContentClick = {})}

        item {Spacer(modifier = Modifier.height(20.dp))}

        item {drama_section(contents = viewModel.newList, onContentClick = {})}

        item {Spacer(modifier = Modifier.height(20.dp))}

        item {soon_section(contents = viewModel.soonList, onContentClick = {})}

        item {Spacer(modifier = Modifier.height(20.dp))}

        item {party_section(contents = viewModel.partyList, onContentClick = {})}

    }
}


