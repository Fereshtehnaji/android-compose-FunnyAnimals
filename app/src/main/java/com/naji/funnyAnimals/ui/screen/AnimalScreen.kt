package com.naji.funnyAnimals.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.LifecycleOwner
import com.naji.funnyAnimals.R
import com.naji.funnyAnimals.data.Animal
import com.naji.funnyAnimals.data.animalenum.TYPE
import com.naji.funnyAnimals.ui.AnimalViewModel
import com.naji.funnyAnimals.ui.components.AppToolbar
import com.naji.funnyAnimals.ui.components.LanguageButton
import com.naji.funnyAnimals.ui.components.MusicButton
import com.naji.funnyAnimals.ui.components.NavigationBackButton
import com.naji.funnyAnimals.ui.util.HandleResourceOnLifeCycle


const val SCREEN_CONST = 120

@Composable
fun NavigateScreen(
    viewModel: AnimalViewModel,
    lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current,
    onBackHandler: () -> Unit,
    title: String,
    backgroundImageId: Int?,
    type: TYPE
) {
    val context = LocalContext.current
    HandleResourceOnLifeCycle(lifecycleOwner, {}, {
        stopSound(context)
        viewModel.unSelectLastItem()
    })


    Surface {
        if (backgroundImageId != null)
            Image(
                painter = painterResource(id = backgroundImageId),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )


        val items: List<Animal> by viewModel.fetchAllAnimals(type).observeAsState(listOf())
        val musicStatus: Boolean by viewModel.backgroundMusicPlaying.observeAsState(initial = viewModel.isMusicPlaying())
        val languageLabel: String by viewModel.appLanguage.observeAsState(initial = viewModel.getLanguageOfApp())

        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            ShowToolbar(viewModel, title, musicStatus, languageLabel, onBackHandler)

            AnimalGrid(animals = items, onClickHandler = { viewModel.clickHandler(it) }, type)
        }


    }
}

@Composable
fun ShowToolbar(
    myViewModel: AnimalViewModel, title: String, isMusicPlay: Boolean,
    languageLabel: String, onBackHandler: () -> Unit
) {

    AppToolbar(modifier = Modifier.height(dimensionResource(id = R.dimen._50sdp)),
        title = title,
        icon1 = {
            MusicButton(
                { myViewModel.musicButtonHandler() },
                isMusicPlay, Color.White
            )
        },
        icon2 = {
            LanguageButton(
                onClick = { myViewModel.changeListLanguage() },
                language = languageLabel, Color.White
            )
        },
        backHandler = {
            NavigationBackButton(onClick = onBackHandler)
        }
    )
}






