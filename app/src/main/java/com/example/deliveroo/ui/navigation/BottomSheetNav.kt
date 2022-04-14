package com.example.deliveroo.ui.navigation

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.FlingBehavior
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
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
import com.example.deliveroo.ui.page.CategoriesButton
import com.example.deliveroo.ui.page.CategoriesCard
import com.example.deliveroo.ui.page.TextHeadings
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomSheetActivity(
    photosViewModel: MyPhotosViewModel = hiltViewModel()
){
    val scope = rememberCoroutineScope()
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = BottomSheetState(BottomSheetValue.Collapsed)
    )
    val context = LocalContext.current
    val asianFoodPhotos = photosViewModel.foodPhotos.value
    val asianIceCreamPhotos = photosViewModel.iceCreamPhotos.value
    val asianDessertPhotos  = photosViewModel.dessertPhotos.value
    val asianSnackPhotos =   photosViewModel.snackPhotos.value
    val selectedButton = photosViewModel.selectedButton.value
    BottomSheetScaffold(
        scaffoldState = bottomSheetScaffoldState,
        sheetContent = {

            when (selectedButton) {
                Categories.Lunch -> {
                    if (!asianFoodPhotos.isNullOrEmpty()){

                        LazyColumn(modifier = Modifier.background(color = colorResource(id = R.color.backgroundColor)),content = {
                            items(items =asianFoodPhotos, itemContent = {asianFood ->
                                val painter = rememberAsyncImagePainter(
                                    model = ImageRequest.Builder(context)
                                        .data(asianFood.full)
                                        .size(Size.ORIGINAL)
                                        .crossfade(enable = true)
                                        .build()

                                )
                                CategoriesCard(
                                    painter = painter,
                                    modifier = Modifier.padding(
                                        5.dp
                                    )
                                )
                            })
                        })

                    }

                }

                Categories.Snacks -> {
                    if (!asianSnackPhotos.isNullOrEmpty()){
                        LazyColumn(modifier = Modifier.background(color = colorResource(id = R.color.backgroundColor)),content = {
                            items(items =asianSnackPhotos, itemContent = {asianSnack ->
                                val painter = rememberAsyncImagePainter(
                                    model = ImageRequest.Builder(context)
                                        .data(asianSnack.full)
                                        .size(Size.ORIGINAL)
                                        .crossfade(enable = true)
                                        .build()

                                )
                                CategoriesCard(
                                    painter = painter,
                                    modifier = Modifier.padding(
                                        5.dp
                                    )
                                )
                            })
                        })
                    }

                }

                Categories.Dessert -> {
                    if (!asianDessertPhotos.isNullOrEmpty()){
                        LazyColumn(modifier = Modifier.background(color = colorResource(id = R.color.backgroundColor)),content = {
                            items(items =asianDessertPhotos, itemContent = {asianDessert ->
                                val painter = rememberAsyncImagePainter(
                                    model = ImageRequest.Builder(context)
                                        .data(asianDessert.full)
                                        .size(Size.ORIGINAL)
                                        .crossfade(enable = true)
                                        .build()

                                )
                                CategoriesCard(
                                    painter = painter,
                                    modifier = Modifier.padding(
                                        5.dp
                                    )
                                )
                            })
                        })
                    }

                }

                Categories.IceCream -> {
                    if (!asianIceCreamPhotos.isNullOrEmpty()){
                        LazyColumn(modifier = Modifier.background(color = colorResource(id = R.color.backgroundColor)),content = {
                            items(items =asianIceCreamPhotos, itemContent = {asianIceCream ->
                                val painter = rememberAsyncImagePainter(
                                    model = ImageRequest.Builder(context)
                                        .data(asianIceCream.full)
                                        .size(Size.ORIGINAL)
                                        .crossfade(enable = true)
                                        .build()

                                )
                                CategoriesCard(
                                    painter = painter,
                                    modifier = Modifier.padding(
                                        5.dp
                                    )
                                )
                            })
                        })
                    }

                }
            }


    },
    sheetPeekHeight = 1.dp,
    backgroundColor = colorResource(id = R.color.backgroundColor),


        ) {
        BehindBottomSheet(scope = scope, bottomSheetScaffoldState = bottomSheetScaffoldState)
    }
}

