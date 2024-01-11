package com.hazem.practiseapp.presentation.screens.common

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit

@Composable
fun TextComponent(
    textValue: String,
    fontSize: TextUnit,
    modifier: Modifier=Modifier,
    color: Color = Color.Black,
) {
    Text(
        text = textValue,
        color = color,
        fontSize = fontSize,
        fontWeight = FontWeight.Light,
        modifier = modifier,
    )
}