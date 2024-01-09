package com.hazem.practiseapp.presentation.screens.user_input

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.hazem.practiseapp.R
import com.hazem.practiseapp.presentation.screens.common.TextComponent
import com.hazem.practiseapp.presentation.screens.common.TopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserInputScreen(
    viewModel: UserInputViewModel = hiltViewModel()
) {
    var currentValue by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TopBar(
            topBarText = stringResource(id = R.string.hi_there),
            modifier = Modifier.padding(18.dp)
        )
        TextComponent(
            textValue = stringResource(id = R.string.paragraph_one),
            modifier = Modifier.padding(start = 18.dp),
            fontSize = 24.sp
        )
        Spacer(modifier = Modifier.size(20.dp))
        TextComponent(
            textValue = stringResource(id = R.string.paragraph_two),
            modifier = Modifier.padding(start = 18.dp),
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.size(60.dp))
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            value = currentValue,
            onValueChange = {
                currentValue=it
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
            )
        )
    }
}

@Composable
@Preview(showBackground = true)
fun UserInputScreenPreview() {
    UserInputScreen()
}