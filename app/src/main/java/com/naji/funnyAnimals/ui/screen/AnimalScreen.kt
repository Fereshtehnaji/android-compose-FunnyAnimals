package com.naji.funnyAnimals.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.material.icons.filled.MusicOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LifecycleOwner
import com.naji.funnyAnimals.data.animalenum.ServiceCommand
import com.naji.funnyAnimals.data.Animal
import com.naji.funnyAnimals.data.AnimalData
import com.naji.funnyAnimals.ui.components.AppToolbar
import com.naji.funnyAnimals.ui.util.HandleResourceOnLifeCycle
import com.naji.funnyAnimals.ui.util.startMusicService


const val SCREEN_CONST = 120

@Composable
fun NavigateScreen(
    viewModel: ViewModel,
    lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current,
    onBackHandler: () -> Unit,
    title: String,
    backgroundImageId: Int
) {
    val context = LocalContext.current
    HandleResourceOnLifeCycle(lifecycleOwner, {}, { stopSound(context) })


    Surface {
        Image(
            painter = painterResource(id = backgroundImageId),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        val items: List<Animal> by viewModel.animalItems.observeAsState(listOf())
        val isMusicPlay: Boolean by viewModel.backgroundMusicPlaying.observeAsState(initial = viewModel.isMusicPlaying())

        Column() {
            AppToolbar(modifier = Modifier.height(50.dp),
                title = title,
                icon = { MusicIcon({ viewModel.musicIconClickHandler() }, isMusicPlay) },
                backHandler = { onBackHandler() })
            AnimalGrid(animals = items, onClickHandler = { viewModel.clickHandler(it) })
        }


    }
}

@Preview
@Composable
fun PreviewAnimalGrid() {
    AnimalGrid(animals = AnimalData.AnimalData, onClickHandler = {})
}

@Composable
fun MusicIcon(onEventHandler: () -> Unit, isMusicPlay: Boolean) {

    val context = LocalContext.current

    val icon = if (isMusicPlay) {
        context.startMusicService(ServiceCommand.START.nameType)
        Icons.Filled.MusicNote
    } else {
        context.startMusicService(ServiceCommand.STOP.nameType)
        Icons.Filled.MusicOff
    }
    IconButton(onClick = {
        onEventHandler()
//        onEventHandler.invoke(NewGameEvent.OnDonePressed)
    }) {
        Icon(
            icon,
            "",
            tint = Color.White,
        )
    }
}







