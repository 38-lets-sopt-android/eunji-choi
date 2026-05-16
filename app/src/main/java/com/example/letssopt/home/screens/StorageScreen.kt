package com.example.letssopt.home.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.letssopt.R
import com.example.letssopt.home.StorageItemModel
import com.example.letssopt.ui.theme.LETSSOPTColors
import com.example.letssopt.ui.theme.Typography

@Composable
fun StorageScreen(
    modifier: Modifier = Modifier
) {
    var items by remember {
        mutableStateOf(
            listOf(
                StorageItemModel(1, "이 사랑 통역 되나요?", R.drawable.img_storage_loveinterpret),
                StorageItemModel(2, "이 사랑 통역 될까나?", R.drawable.img_storage_loveinterpret),
                StorageItemModel(3, "이 사랑 통역 되나?", R.drawable.img_storage_loveinterpret),
                StorageItemModel(4, "이 사랑 통역 될까?", R.drawable.img_storage_loveinterpret),
                StorageItemModel(5, "이 사랑 통역 되려나?", R.drawable.img_storage_loveinterpret),
            )
        )
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(LETSSOPTColors.BackGround)
            .padding(top = 70.dp)
            .padding(horizontal = 16.dp)

    ) {
        Text(
            text = "찜한 목록",
            color = LETSSOPTColors.White,
            style = Typography.h3
        )

        Spacer(modifier = Modifier.height(45.dp))

        if (items.isEmpty()) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = "찜해놓은 목록이 없습니다", color = LETSSOPTColors.White)
            }
        }
        else {
            LazyVerticalGrid(
                modifier = Modifier.fillMaxSize(),
                columns = GridCells.Fixed(3),
                horizontalArrangement = Arrangement.spacedBy(14.dp),
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                items(items) { index ->
                    StoredItems(
                        content = index,
                        onDeleteClicked = {items = items.filter { it.id != index.id }}
                    )
                }
            }
        }
    }
}

@Composable
fun StoredItems(
    content: StorageItemModel,
    modifier: Modifier = Modifier,
    onDeleteClicked: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = content.image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .aspectRatio(2f / 3f)
                .clip(RoundedCornerShape(10.dp))
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = content.title,
            style = Typography.body4,
            color = LETSSOPTColors.White
        )

        Spacer(modifier = Modifier.height(6.dp))

        Icon(
            painter = painterResource(R.drawable.ic_storage_delete),
            contentDescription = null,
            modifier = Modifier
                .clickable{ onDeleteClicked() },
            tint = Color.Unspecified
        )
    }
}

@Preview
@Composable
private fun StorageScreenPreview() {
    StorageScreen()
}