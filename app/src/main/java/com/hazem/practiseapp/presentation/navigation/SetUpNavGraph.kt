package com.hazem.practiseapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.hazem.practiseapp.presentation.screens.user_input.UserInputScreen
import com.hazem.practiseapp.presentation.screens.welcome.WelcomeScreen
import com.hazem.practiseapp.utils.Constants.NAME
import com.hazem.practiseapp.utils.Constants.SELECTED_ANIMAL

@Composable
fun SetUpNavGraph(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Screen.UserInputScreen.route) {
        composable(route = Screen.WelcomeScreen.route, arguments = listOf(
            navArgument(SELECTED_ANIMAL) {
                type = NavType.StringType
            },
            navArgument(NAME) {
                type = NavType.StringType
            }
        )) {
            val name= it.arguments?.getString(NAME)
            val selectedAnimal= it.arguments?.getString(SELECTED_ANIMAL)
            WelcomeScreen(name,selectedAnimal)
        }
        composable(route = Screen.UserInputScreen.route) {
            UserInputScreen(navController = navController)
        }
    }
}