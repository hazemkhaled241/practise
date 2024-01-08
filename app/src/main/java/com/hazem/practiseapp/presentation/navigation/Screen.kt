package com.hazem.practiseapp.presentation.navigation

sealed class Screen(val route:String) {

    object WelcomeScreen:Screen("welcome_screen")
    object UserInputScreen:Screen("user_input_screen")
}