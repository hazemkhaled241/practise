package com.hazem.practiseapp.presentation.navigation

import com.hazem.practiseapp.utils.Constants.NAME
import com.hazem.practiseapp.utils.Constants.SELECTED_ANIMAL

sealed class Screen(val route:String) {

    object WelcomeScreen:Screen("welcome_screen/{${SELECTED_ANIMAL}}/{${NAME}}"){
        fun setData(selectedName:String,name:String):String{
            return "welcome_screen/$selectedName/$name"
        }
    }
    object UserInputScreen:Screen("user_input_screen")
}