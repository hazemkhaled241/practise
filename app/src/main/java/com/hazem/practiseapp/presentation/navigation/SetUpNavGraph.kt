package com.hazem.practiseapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.hazem.practiseapp.presentation.screens.user_input_screen.UserInputScreen
import com.hazem.practiseapp.presentation.screens.welcome.WelcomeScreen

@Composable
fun SetUpNavGraph(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Screen.WelcomeScreen.route) {
        composable(route=Screen.WelcomeScreen.route) {
          WelcomeScreen(navController)
        }
        composable(route=Screen.UserInputScreen.route){
            UserInputScreen()
        }
    }
}