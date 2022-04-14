package com.example.deliveroo.ui.page

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.example.deliveroo.R
import com.example.deliveroo.model.Categories
import com.example.deliveroo.model.MyPhotosViewModel
import com.example.deliveroo.model.categoriesList
import com.example.deliveroo.ui.navigation.BottomSheetActivity
import com.example.deliveroo.ui.theme.DeliverooTheme

@Composable
fun HomeScreen(photosViewModel: MyPhotosViewModel = hiltViewModel()) {
    val context = LocalContext.current
    val asianChefPhotos = photosViewModel.chefPhotos.value
    val asianFoodPhotos = photosViewModel.foodPhotos.value

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(color = colorResource(id = R.color.backgroundColor))
            .verticalScroll(rememberScrollState())
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
        )
        {
            Image(
                painter = painterResource(id = R.drawable.red_crabs_seafood_logo),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(100.dp)
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp),
            ) {
                TextHeadings(
                    title = "Delicious asian food",
                    textSize = 25.sp,
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(vertical = 16.dp)
                )
                Text(
                    text = "Red Crabs is watching, hunger has no chance ",
                    fontSize = 12.sp,
                    textAlign = TextAlign.Left,
                    color = Color.Black,

                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(vertical = 10.dp)


                )
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null,
                    tint = Color.Red,
                    modifier = Modifier
                        .size(60.dp)
                        .align(Alignment.TopEnd)
                        .padding(12.dp)

                )
            }
        }

        LazyRow(
            modifier = Modifier.fillMaxWidth()
        ) {
            if (asianChefPhotos.isNotEmpty()){
            items(items = asianChefPhotos, itemContent = { item ->
                val painter = rememberAsyncImagePainter(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(item.regular)
                        .size(Size.ORIGINAL)
                        .crossfade(enable = true)
                        .build()
                )
                PromoImageShapeCard(
                    painter = painter,
                    cardHeight = 150.dp,
                    cardWidth = 120.dp
                )

            })
        }
        }

        TextHeadings(
            title = "Popular and new ",
            textSize = 20.sp,
            modifier = Modifier.padding(start = 15.dp, bottom = 10.dp, top = 5.dp)
        )

        LazyRow(contentPadding = PaddingValues()) {
            if (asianFoodPhotos.isNotEmpty()){
            items(items = asianFoodPhotos, itemContent = { item ->
                val painter = rememberAsyncImagePainter(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(item.full)
                        .size(Size.ORIGINAL)
                        .crossfade(enable = true)
                        .build()
                )
                PopularAndNewCard(
                    painter = painter,
                    cardWidth = 150.dp,
                    cardHeight = 100.dp
                )

            })
            }
        }

    }
}


@Preview
@Composable
fun PreviewHomeScreen() {
    DeliverooTheme {
        HomeScreen()
    }
}