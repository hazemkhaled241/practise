package com.hazem.practiseapp.presentation.screens.user_input_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hazem.practiseapp.R
import com.hazem.practiseapp.presentation.screens.common.TextComponent
import com.hazem.practiseapp.presentation.screens.common.TopBar

@Composable
fun UserInputScreen() {

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
        TextComponent(textValue = stringResource(id = R.string.paragraph_two), modifier = Modifier.padding(start = 18.dp), fontSize = 18.sp)

    }
}

@Composable
@Preview(showBackground = true)
fun UserInputScreenPreview() {
    UserInputScreen()
}