package com.example.deliveroo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.deliveroo.ui.OnboardingUI
import com.example.deliveroo.ui.page.LoginForm
import com.example.deliveroo.ui.page.HomeScreen
import com.example.deliveroo.ui.page.SignUpForm
import com.example.deliveroo.ui.theme.DeliverooTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DeliverooTheme {
                // A surface container using the 'background' color from the theme

                    DeliverooAppScreen()

            }
        }
    }
}


@Composable
fun DeliverooAppScreen () {
    val navController =  rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "onBoardingScreen"
    ){
        composable(route = "onBoardingScreen"){
            OnboardingUI(onButtonClick = { navigateToLoginForm(navController) })
        }
        composable(route = "loginForm"){
            LoginForm(
                onSignUpClick = { navigateToSignUpForm(navController)},
                onLoginClick = { navigateToHomeScreen(navController)}
            )
        }
        composable(route="signupForm"){
            SignUpForm(onSignUpClicked = { navigateToLoginForm(navController) })
        }
        composable(route = "homeScreen"){
            HomeScreen()
        }
    }
}


private fun navigateToLoginForm(navController: NavHostController){
    navController.navigate("loginForm")
}
private fun navigateToSignUpForm(navController: NavHostController){
    navController.navigate ("signupForm")
}
private fun navigateToHomeScreen(navController: NavHostController){
    navController.navigate ("homeScreen")
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DeliverooTheme {

    }
}