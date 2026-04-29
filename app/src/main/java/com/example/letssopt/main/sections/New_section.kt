package com.example.letssopt.main.sections

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
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
import com.example.letssopt.ui.theme.LETSSOPTColors
import com.example.letssopt.ui.theme.Typography

@Composable
fun New_section(
    contents: List<Int>,
    onContentClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
    ){
        Text(
            text = "방금 막 도착한 신상 컨텐츠!",
            style = Typography.h3,
            color = LETSSOPTColors.White
        )

        Text(
            text = "예능부터 드라마까지!",
            style = Typography.sh1,
            color = LETSSOPTColors.Text_Tertiary
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


}