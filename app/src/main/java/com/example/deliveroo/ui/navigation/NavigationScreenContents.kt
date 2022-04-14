package com.example.deliveroo.ui.navigation

import android.util.Log
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.BottomSheetScaffoldState
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.deliveroo.model.Categories
import com.example.deliveroo.model.MyPhotosViewModel
import com.example.deliveroo.model.categoriesList
import com.example.deliveroo.ui.page.CategoriesButton
import com.example.deliveroo.ui.page.CategoriesCard
import com.example.deliveroo.ui.page.HomeScreen
import com.example.deliveroo.ui.page.TextHeadings
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun MenuScreen() {
    BottomSheetActivity()
}

@Composable
fun FavoriteScreen (){
    Text(text = "Favorites", fontSize = 100.sp)
}

@Composable
fun ProfileScreen (){
    Text(text = "Profile", fontSize = 100.sp)

}
@Composable
fun CartScreen(){
    Text(text = "Cart", fontSize = 100.sp)

}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BehindBottomSheet(
    scope : CoroutineScope,
    bottomSheetScaffoldState : BottomSheetScaffoldState,
    photosViewModel: MyPhotosViewModel = hiltViewModel()
) {
    val onSelectionChange :(Categories) -> Unit = {photosViewModel.selectedButton.value = it }

    HomeScreen()

    TextHeadings(
        title = "Categories",
        textSize = 20.sp,
        modifier = Modifier.padding(start = 15.dp, bottom = 10.dp, top = 5.dp)
    )

    LazyRow(contentPadding = PaddingValues(start = 15.dp, end = 15.dp)) {
        items(items = categoriesList, itemContent = { item ->
            CategoriesButton(
                categoryName = item.title,
                icon = painterResource(id = item.Icon),
                onButtonClick = {
                    onSelectionChange(item)
                    scope.launch{
                        if (bottomSheetScaffoldState.bottomSheetState.isCollapsed){
                            bottomSheetScaffoldState.bottomSheetState.expand()
                            Log.d("EXPAND", "${bottomSheetScaffoldState.bottomSheetState.isExpanded}")
                        } else {
                            bottomSheetScaffoldState.bottomSheetState.collapse()
                            Log.d("COLLAPSE", "${bottomSheetScaffoldState.bottomSheetState.isCollapsed} ")

                        }
                    }


                },
                colors = ButtonDefaults.outlinedButtonColors(
                    backgroundColor = if (item == photosViewModel.selectedButton.value) Color(0xffe42021) else Color.LightGray,
                    contentColor = Color.White
                ),
            )

        })
    }
    CategoriesCard(modifier = Modifier.padding(
        start = 15.dp,
        top = 30.dp,
        end = 15.dp,
        bottom = 15.dp
    ))

}