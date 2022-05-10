package com.naji.funnyAnimals.ui.screen


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.naji.funnyAnimals.R
import com.naji.funnyAnimals.ui.AnimalViewModel
import com.naji.funnyAnimals.ui.components.AppToolbar
import com.naji.funnyAnimals.ui.components.NavigationBackButton

@Composable
fun SettingScreen(
    viewModel: AnimalViewModel,
    onBackHandler: () -> Unit,
    title: String,
    backgroundImageId: Int?,
) {
    Surface {
        if (backgroundImageId != null)
            Image(
                painter = painterResource(id = backgroundImageId),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )



        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            ShowToolbar(title, onBackHandler)

            var sliderPosition1 by remember { mutableStateOf(0f) }
            Text(text = stringResource(id = R.string.background_music_volume))
            Slider(
                value = sliderPosition1,
                onValueChange = { sliderPosition1 = it },
                valueRange = 0f..100f,
                onValueChangeFinished = {
                     viewModel.updateSelectedSliderValue(sliderPosition1)
                },
                steps = 5,
                colors = SliderDefaults.colors(
                    thumbColor = MaterialTheme.colors.secondary,
                    activeTrackColor = MaterialTheme.colors.secondary
                ),
                modifier = Modifier.padding(start = 16.dp, end = 16.dp)
            )

            Spacer(Modifier.height(dimensionResource(id = R.dimen._18sdp)))

            var sliderPosition2 by remember { mutableStateOf(0f) }

            Text(text = stringResource(id = R.string.animal_sound_volume))
            Slider(
                value = sliderPosition2,
                onValueChange = { sliderPosition2 = it },
                valueRange = 0f..100f,
                onValueChangeFinished = {
                    // launch some business logic update with the state you hold
                    // viewModel.updateSelectedSliderValue(sliderPosition)
                },
                steps = 5,
                colors = SliderDefaults.colors(
                    thumbColor = MaterialTheme.colors.secondary,
                    activeTrackColor = MaterialTheme.colors.secondary
                ),
                modifier = Modifier.padding(start = 16.dp, end = 16.dp)
            )
        }


    }

}

@Composable
fun ShowToolbar(
    title: String, onBackHandler: () -> Unit
) {

    AppToolbar(modifier = Modifier.height(dimensionResource(id = R.dimen._50sdp)),
        title = title,

        backHandler = {
            NavigationBackButton(onClick = onBackHandler)
        }
    )
}