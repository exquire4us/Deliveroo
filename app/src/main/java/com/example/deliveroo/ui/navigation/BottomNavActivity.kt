package com.example.deliveroo.ui.navigation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
fun BottomNavigationGraph (navController: NavHostController) {
    NavHost(navController = navController, startDestination = BottomNavItem.Home.route ){
        composable(BottomNavItem.Home.route){
            MenuScreen()
        }
        composable(BottomNavItem.Favorites.route) {
            FavoriteScreen()
        }
        composable(BottomNavItem.Profile.route) {
            ProfileScreen()
        }
        composable(BottomNavItem.Cart.route){
            CartScreen()
        }
    }
}

@Composable
fun BottomNavigation(navController: NavHostController){
    val navItems = listOf(
        BottomNavItem.Home,
        BottomNavItem.Favorites,
        BottomNavItem.Profile,
        BottomNavItem.Cart
    )
    androidx.compose.material.BottomNavigation(
        backgroundColor = Color.LightGray.copy(1f),
        contentColor = Color.Red,
        elevation = 20.dp,
        modifier = Modifier.fillMaxWidth().padding(15.dp).clip(RoundedCornerShape(15.dp))

    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        navItems.forEach{item ->
            BottomNavigationItem(
                icon = { Icon(painter = painterResource(id = item.icon), contentDescription = item.title, tint = if (currentRoute == item.route) Color.Red else Color.DarkGray, modifier = Modifier.size(20.dp))},
                selected = currentRoute == item.route,
                label = { Text(text = item.title, fontSize = 9.sp)},
                selectedContentColor = Color.Red,
                unselectedContentColor = Color.DarkGray,
                alwaysShowLabel = true,
                onClick = {
                    navController.navigate(item.route){
                        navController.graph.startDestinationRoute?.let {route->
                            popUpTo(route){
                                saveState = true
                            }

                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },)
        }
    }
}

@Composable
fun MainScreen(){
    val navController = rememberNavController()
    Scaffold(
        bottomBar =  {
            BottomNavigation(navController = navController)
        }
    ) {
        BottomNavigationGraph(navController = navController)
    }
}