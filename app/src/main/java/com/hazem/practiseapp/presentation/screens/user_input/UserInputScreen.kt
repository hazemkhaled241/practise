package com.hazem.practiseapp.presentation.screens.user_input

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.hazem.practiseapp.R
import com.hazem.practiseapp.presentation.navigation.Screen
import com.hazem.practiseapp.presentation.screens.common.AnimalCard
import com.hazem.practiseapp.presentation.screens.common.TextComponent
import com.hazem.practiseapp.presentation.screens.common.TopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserInputScreen(
    viewModel: UserInputViewModel = hiltViewModel(),
    navController:NavHostController
) {
    var currentValue by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(18.dp)
    ) {
        TopBar(
            topBarText = stringResource(id = R.string.hi_there),
            image = R.drawable.emogi_1
        )

        Spacer(modifier = Modifier.size(20.dp))
        TextComponent(
            textValue = stringResource(id = R.string.paragraph_one),
            fontSize = 24.sp
        )
        Spacer(modifier = Modifier.size(20.dp))
        TextComponent(
            textValue = stringResource(id = R.string.paragraph_two),
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.size(60.dp))
        TextComponent(
            textValue = stringResource(id = R.string.name),
            fontSize = 18.sp
        )
        val localFocusManager = LocalFocusManager.current
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp),
            value = currentValue,
            onValueChange = {
                currentValue = it
                viewModel.onEvent(UserInputScreenEvent.Text(it))
            },
            placeholder = {
                Text(
                    text = stringResource(id = R.string.enter_your_name),
                    style = TextStyle(fontSize = 18.sp)
                )
            },
            textStyle = TextStyle.Default.copy(fontSize = 24.sp),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions {
                localFocusManager.clearFocus()
            }
        )

        Spacer(modifier = Modifier.size(20.dp))
        TextComponent(
            textValue = stringResource(id = R.string.paragraph_four),
            fontSize = 18.sp
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp)
        ) {
            AnimalCard(image = R.drawable.cat,
                viewModel.userInputState.value.selectedAnimal == "Cat", animalSelected = {
                    viewModel.onEvent(UserInputScreenEvent.SelectedAnimal(it))
                })
            AnimalCard(
                image = R.drawable.dog,
                viewModel.userInputState.value.selectedAnimal == "Dog",
                animalSelected = {
                    viewModel.onEvent(UserInputScreenEvent.SelectedAnimal(it))
                })
        }

        Spacer(modifier = Modifier.size(20.dp))
        if (viewModel.isValidState()) {
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp),
                onClick = {
                    navController.navigate(
                        Screen.WelcomeScreen.setData(
                            name = viewModel.userInputState.value.text,
                            selectedName = viewModel.userInputState.value.selectedAnimal
                        )
                    )
                },

                ) {
                TextComponent(
                    textValue = stringResource(R.string.go_to_details_screen),
                    fontSize = 18.sp,
                    color = Color.White
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun UserInputScreenPreview() {
    UserInputScreen(navController = rememberNavController())
}