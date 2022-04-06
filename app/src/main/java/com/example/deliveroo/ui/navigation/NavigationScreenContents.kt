package com.example.deliveroo.ui.navigation

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import com.example.deliveroo.ui.page.HomeScreen

@Composable
fun MenuScreen() {
    HomeScreen()
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