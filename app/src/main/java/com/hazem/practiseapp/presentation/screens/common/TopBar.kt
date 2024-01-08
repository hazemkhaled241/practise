package com.hazem.practiseapp.presentation.screens.common

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.hazem.practiseapp.R

@Composable
fun TopBar(topBarText: String,modifier: Modifier) {
    Row(
        modifier = modifier,

        ) {
        Text(
            text = topBarText,
            fontSize = 24.sp,
            color = Color.Black,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
@Preview(showBackground = true)
fun TopBarPreview() {
    TopBar(stringResource(id = R.string.hi_there),Modifier)
}