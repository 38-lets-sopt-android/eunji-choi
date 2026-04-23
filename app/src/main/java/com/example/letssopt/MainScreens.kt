package com.example.letssopt

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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

// 각 탭 화면들 (함수 하나 = 화면 하나)
@Composable
fun MainScreen(
    viewModel: MainViewModel = viewModel()
) {
    LazyColumn {
        item {
            Text(
                text = "방금 막 도착한 신상 컨텐츠!",
                fontFamily = FontFamily(Font(R.font.pretendard_bold)),
                fontSize = 20.sp,
                color = Color.White,
                modifier = Modifier
            )
        }

        item {
            Text(
                text = "예능부터 드라마까지!",
                fontFamily = FontFamily(Font(R.font.pretendard_bold)),
                fontSize = 15.sp,
                color = Color.Gray,
                modifier = Modifier
            )
        }

        item {
            LazyRow {
                items(viewModel.newList) { imageRes ->
                    Image(
                        painter = painterResource(id = imageRes),
                        contentDescription = null,
                        modifier = Modifier
                            .size(200.dp)
                            .padding(8.dp)
                    )
                }
            }
        }

        item {
            Text(
                text = "예능부터 드라마까지!",
                fontFamily = FontFamily(Font(R.font.pretendard_bold)),
                fontSize = 15.sp,
                color = Color.White,
                modifier = Modifier
            )
        }

        item {
            LazyRow {
                items(viewModel.dramaList) { imageRes ->
                    Image(
                        painter = painterResource(id = imageRes),
                        contentDescription = null,
                        modifier = Modifier
                            .size(200.dp)
                            .padding(8.dp)
                    )
                }
            }
        }

        item {
            Text(
                text = "공개 예정 콘텐츠",
                fontFamily = FontFamily(Font(R.font.pretendard_bold)),
                fontSize = 15.sp,
                color = Color.White,
                modifier = Modifier
            )
        }

        item {
            LazyRow {
                items(viewModel.soonList) { imageRes ->
                    Image(
                        painter = painterResource(id = imageRes),
                        contentDescription = null,
                        modifier = Modifier
                            .size(200.dp)
                            .padding(8.dp)
                    )
                }
            }
        }
    }
}

    @Composable
fun PurchaseScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "개별 구매 화면")
    }
}

@Composable
fun WebtoonScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "웹툰 화면")
    }
}

@Composable
fun SearchScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "찾기 화면")
    }
}

@Composable
fun StorageScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "보관함 화면")
    }
}
