package com.hazem.practiseapp.presentation.screens.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hazem.practiseapp.R

@Composable
fun TopBar(topBarText: String, modifier: Modifier=Modifier,image:Int) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically


        ) {
        Text(
            text = topBarText,
            fontSize = 24.sp,
            color = Color.Black,
            fontWeight = FontWeight.Medium
        )

        Spacer(modifier = Modifier.size(10.dp))
        Image(
            modifier=Modifier.size(20.dp),
            painter = painterResource(id = image), contentDescription = stringResource(
                R.string.happy_emoji
            ),


        )
    }
}

@Composable
@Preview(showBackground = true)
fun TopBarPreview() {
    TopBar(stringResource(id = R.string.hi_there), Modifier, R.drawable.emogi_1)
}