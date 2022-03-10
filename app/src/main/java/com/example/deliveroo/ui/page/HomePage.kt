package com.example.deliveroo.ui.page

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
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
import com.example.deliveroo.R
import com.example.deliveroo.model.MyPhoto
import com.example.deliveroo.model.PhotoUrls
import com.example.deliveroo.network.UnsplashApi
import com.example.deliveroo.ui.theme.DeliverooTheme
import kotlinx.coroutines.launch

@Composable
fun MenuScreen (){
    val photos = getSamplePhotos()
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.backgroundColor))
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
        )
        {
            Image(
                painter = painterResource(id = R.drawable.red_crabs_seafood_logo)
                , contentDescription = null,
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
                Text(text = "Red Crabs is watching, hunger has no chance ",
                    fontSize = 12.sp,
                    textAlign = TextAlign.Left,
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

            LazyRow(content ={
                if (!photos.isNullOrEmpty() ){
                    items(count = photos.size,
                        itemContent = {index->
                            PromoImageShapeCard(context = context , data = photos[index].urls.regular)
                    })
                }
            } )


        }
    }
}

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun getSamplePhotos () :List<MyPhoto>{
    val scope = rememberCoroutineScope()
    var photoList : List<MyPhoto> = emptyList()
     scope.launch {
         photoList =
             UnsplashApi.retrofitService.getPhotos()
    }
    return photoList
}


@Preview
@Composable
fun PreviewHomeScreen() {
    DeliverooTheme {
        MenuScreen()
    }
}