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

// 각 탭 화면들 (함수 하나 = 화면 하나)
@Composable
fun HomeScreen(
    viewModel: MainViewModel
) {
    LazyColumn {
        item {
            Spacer(modifier = Modifier.height(30.dp))
        }

        item {
            Text(
                text = "방금 막 도착한 신상 컨텐츠!",
                fontFamily = FontFamily(Font(R.font.pretendard_bold)),
                fontSize = 20.sp,
                color = Color.White
            )
        }

        item {
            Text(
                text = "예능부터 드라마까지!",
                fontFamily = FontFamily(Font(R.font.pretendard_bold)),
                fontSize = 15.sp,
                color = Color.Gray
            )
        }

        item {
            LazyRow {
                items(viewModel.newList) { imageRes ->
                    Image(
                        painter = painterResource(id = imageRes),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .width(330.dp)
                            .aspectRatio(16f / 9f)
                            .padding(8.dp)
                            .clip(RoundedCornerShape(16.dp))
                    )
                }
            }
        }

        item {
            Spacer(modifier = Modifier.height(20.dp))
        }

        // 왓고리즘
        item {
            Column {
                Image(
                    painter = painterResource(id = R.drawable.img_logo_whatgorism),
                    contentDescription = null
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "예능부터 드라마까지!",
                        fontFamily = FontFamily(Font(R.font.pretendard_bold)),
                        fontSize = 20.sp,
                        color = Color.Gray,
                    )
                    Text(
                        text = "더보기",
                        fontFamily = FontFamily(Font(R.font.pretendard_regular)),
                        fontSize = 15.sp,
                        color = Color.Gray,
                    )
                }

            }
        }


        item {
            LazyRow {
                items(viewModel.dramaList) { imageRes ->
                    Image(
                        painter = painterResource(id = imageRes),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .width(150.dp)
                            .aspectRatio(3f / 4f)
                            .padding(8.dp)
                            .clip(RoundedCornerShape(16.dp))
                    )
                }
            }
        }

        item {
            Spacer(modifier = Modifier.height(20.dp))
        }

        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "공개 예정 콘텐츠",
                    fontFamily = FontFamily(Font(R.font.pretendard_bold)),
                    fontSize = 20.sp,
                    color = Color.White
                )
                Text(
                    text = "더보기",
                    fontFamily = FontFamily(Font(R.font.pretendard_regular)),
                    fontSize = 15.sp,
                    color = Color.Gray,
                )
            }
        }

        item {
            LazyRow {
                items(viewModel.soonList) { imageRes ->
                    Image(
                        painter = painterResource(id = imageRes),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .width(150.dp)
                            .aspectRatio(3f / 4f)
                            .padding(8.dp)
                            .clip(RoundedCornerShape(16.dp))
                    )
                }
            }
        }

        item {
            Spacer(modifier = Modifier.height(20.dp))
        }

        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "왓챠 파티",
                    fontFamily = FontFamily(Font(R.font.pretendard_bold)),
                    fontSize = 20.sp,
                    color = Color.White
                )
                Text(
                    text = "더보기",
                    fontFamily = FontFamily(Font(R.font.pretendard_regular)),
                    fontSize = 15.sp,
                    color = Color.Gray,
                )
            }
        }

        item {
            LazyRow {
                items(viewModel.partyList) { party ->
                    Column(
                        modifier = Modifier
                            .width(200.dp)
                            .padding(8.dp)
                    ) {
                        Image(
                            painter = painterResource(id = party.imageRes),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .fillMaxSize()
                                .aspectRatio(6f / 5f)
                        )
                        Column(
                            modifier = Modifier
                                .background(Color.Black)
                                .fillMaxWidth()
                                .padding(6.dp)
                        ) {
                            Text(
                                text = party.time,
                                fontSize = 10.sp,
                                color = Color.Magenta
                            )
                            Text(
                                text = party.title,
                                fontSize = 12.sp,
                                color = Color.White
                            )
                        }
                    }
                }
            }
        }

    }
}


