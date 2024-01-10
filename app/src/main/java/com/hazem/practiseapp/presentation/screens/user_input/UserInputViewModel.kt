package com.hazem.practiseapp.presentation.screens.user_input

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserInputViewModel @Inject constructor(): ViewModel() {
    private val _userInputState = mutableStateOf(UserInputScreenState())
    val userInputState: State<UserInputScreenState> = _userInputState


    fun onEvent(event:UserInputScreenEvent){
        when(event){
            is UserInputScreenEvent.Text -> {
             _userInputState.value=userInputState.value.copy(
                 text = event.value
             )
            }
            is UserInputScreenEvent.SelectedAnimal -> {
                _userInputState.value=userInputState.value.copy(
                    selectedAnimal = event.value
                )
                Log.d("hhh", userInputState.value.selectedAnimal)
            }
        }
    }

}