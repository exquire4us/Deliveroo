package com.example.deliveroo.ui.navigation

import androidx.annotation.DrawableRes
import com.example.deliveroo.R

sealed class BottomNavItem (val title: String, val  icon : Int , val route: String ){
    object Home: BottomNavItem("Menu", R.drawable.ic_find_us,"my_menu")
    object Favorites : BottomNavItem("Favorites",R.drawable.ic_icon_3,"my_favorites")
    object Profile : BottomNavItem("Profile",R.drawable.person_icon,"my_profile")
    object Cart: BottomNavItem("Cart",R.drawable.ic_ecommerce_06,"my_cart")
}
