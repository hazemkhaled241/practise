package com.hazem.practiseapp.presentation.screens.common

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun TextWithShadow(
    text:String,
    modifier: Modifier=Modifier
){
    Text(
        modifier = modifier,
        text = text,
        fontSize = 24.sp,
        fontWeight = FontWeight.Light,
        style = TextStyle(
            shadow = Shadow(Color.Gray, offset = Offset(x = 1f, y = 2f), blurRadius = 2f)
        )
    )
}