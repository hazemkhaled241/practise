package com.hazem.practiseapp.presentation.screens.user_input

sealed class UserInputScreenEvent {
    data class Text(val value:String):UserInputScreenEvent()
    data class SelectedAnimal(val value:String):UserInputScreenEvent()
}