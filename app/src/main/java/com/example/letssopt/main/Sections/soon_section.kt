package com.example.letssopt.main.Sections

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
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

@Composable
fun soon_section(
    contents: List<Int>,
    onContentClick: () -> Unit,
    modifier: Modifier = Modifier
) {

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

    LazyRow {
        items(contents) { imageRes ->
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