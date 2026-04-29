package com.example.letssopt.main.Sections

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.letssopt.R
import com.example.letssopt.main.MainViewModel
import com.example.letssopt.main.PartyItem
import kotlinx.collections.immutable.ImmutableList

@Composable
fun party_section(
    contents: List<PartyItem>,
    onContentClick: () -> Unit,
    modifier: Modifier = Modifier
) {

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

    LazyRow {
        items(contents) { party ->
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