package com.hazem.practiseapp.presentation.screens.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hazem.practiseapp.R

@Composable
fun AnimalCard(
    image: Int,
    selected: Boolean,
    animalSelected: (animalName: String) -> Unit
) {

    val localFocusManager = LocalFocusManager.current
    Card(
        modifier = Modifier
            .padding(24.dp)
            .size(130.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 1.dp,
                    color = if (selected) Color.Green else Color.Transparent,
                    shape = RoundedCornerShape(8.dp)
                )
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = stringResource(R.string.animal_image),
                modifier = Modifier
                    .padding(15.dp)
                    .clickable {
                        localFocusManager.clearFocus()
                        val animalName = if (image == R.drawable.cat) "Cat" else "Dog"
                        animalSelected(animalName)
                    }
            )
        }
    }
}

@Composable
@Preview
fun AnimalCardPreview() {
    AnimalCard(R.drawable.cat, true, animalSelected = {})
}