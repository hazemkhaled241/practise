package com.hazem.practiseapp.presentation.screens.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hazem.practiseapp.R
import com.hazem.practiseapp.presentation.screens.common.TextComponent
import com.hazem.practiseapp.presentation.screens.common.TextWithShadow
import com.hazem.practiseapp.presentation.screens.common.TopBar


@Composable
fun WelcomeScreen(name: String?, selectedAnimal: String?) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(18.dp)
    ) {
        TopBar(
            topBarText = "Welcome $name",
            image = R.drawable.emoji_2
        )

        Spacer(modifier = Modifier.size(20.dp))
        TextComponent(
            textValue = stringResource(id = R.string.paragraph_three),
            fontSize = 24.sp
        )

        Spacer(modifier = Modifier.size(50.dp))
        TextWithShadow(text = "You are a $selectedAnimal Lover.")
        Spacer(modifier = Modifier.size(40.dp))

        Card(
            modifier = Modifier
                .padding(24.dp)
                .size(height = 230.dp, width = 500.dp),
            elevation = CardDefaults.cardElevation(4.dp)
        ) {
            Column(modifier = Modifier.padding(18.dp, 24.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.double_quote_left),
                    contentDescription = stringResource(
                        R.string.double_quote_left
                    ),
                    modifier = Modifier
                        .size(20.dp)
                        .align(Alignment.CenterHorizontally)
                )
                Spacer(modifier = Modifier.size(20.dp))
                TextWithShadow(
                    text = handleMessageBody(selectedAnimal),
                    modifier=Modifier.padding(horizontal = 32.dp)
                )
                Spacer(modifier = Modifier.size(20.dp))

                Image(
                    painter = painterResource(id = R.drawable.double_quote_right),
                    contentDescription = stringResource(
                        R.string.double_quote_right
                    ),
                    modifier = Modifier
                        .size(20.dp)
                        .align(Alignment.CenterHorizontally)
                )
            }

        }
    }

}

@Composable
@Preview(showBackground = true)
fun WelcomeScreenPreview() {
    WelcomeScreen(
        name = "Hazem",
        selectedAnimal = "Dog"
    )
}

fun handleMessageBody(selectedAnimal: String?): String {
    return if (selectedAnimal == "Cat") "If cats could talk they'd probably just ask for more treats."
    else "If dogs could talk they'd probably just ask for more treats."
}