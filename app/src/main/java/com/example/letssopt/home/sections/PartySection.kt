package com.example.letssopt.home.sections

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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.letssopt.home.PartyItem
import com.example.letssopt.ui.theme.LETSSOPTColors
import com.example.letssopt.ui.theme.LETSSOPTTheme
import com.example.letssopt.ui.theme.Typography

@Composable
fun PartySection(
    contents: List<PartyItem>,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier.fillMaxSize()
    ){
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "왓챠 파티",
                style = Typography.h3,
                color = LETSSOPTColors.White
            )
            Text(
                text = "더보기",
                style = Typography.caption2,
                color = LETSSOPTColors.Text_Secondary
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
                            .fillMaxWidth()
                            .aspectRatio(6f / 5f)
                    )
                    Column(
                        modifier = Modifier
                            .background(color = LETSSOPTColors.BackGround)
                            .fillMaxWidth()
                            .padding(6.dp)
                    ) {
                        Text(
                            text = party.time,
                            style = Typography.body3,
                            color = LETSSOPTColors.Primary_Red
                        )
                        Text(
                            text = party.title,
                            style = Typography.sh3,
                            color = LETSSOPTColors.White
                        )
                    }
                }
            }
        }
    }
}


@Preview
@Composable
private fun Party_sectionPreview() {
    LETSSOPTTheme {
        PartySection(
            contents = fakepartyList
        )
    }
}