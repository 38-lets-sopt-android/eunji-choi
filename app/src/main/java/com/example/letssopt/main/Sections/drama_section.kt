package com.example.letssopt.main.Sections

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import kotlinx.collections.immutable.ImmutableList

@Composable
fun drama_section(
    contents: List<Int>,
    onContentClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    Text(
    text = "방금 막 도착한 신상 컨텐츠!",
    fontFamily = FontFamily(Font(R.font.pretendard_bold)),
    fontSize = 20.sp,
    color = Color.White
    )

    Text(
    text = "예능부터 드라마까지!",
    fontFamily = FontFamily(Font(R.font.pretendard_bold)),
    fontSize = 15.sp,
    color = Color.Gray
    )


    LazyRow {
        items(contents) { item ->
            Image(
                painter = painterResource(id = item),
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