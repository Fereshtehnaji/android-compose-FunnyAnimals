package com.naji.funnyAnimals.ui.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.material.icons.filled.MusicOff
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.naji.funnyAnimals.data.animalenum.ServiceCommand
import com.naji.funnyAnimals.ui.util.startMusicService

@Composable
fun MusicButton(onClick: () -> Unit, isMusicPlay: Boolean, color: Color) {

    val context = LocalContext.current

    val icon = if (isMusicPlay) {
        context.startMusicService(ServiceCommand.START.nameType)
        Icons.Filled.MusicNote
    } else {
        context.startMusicService(ServiceCommand.STOP.nameType)
        Icons.Filled.MusicOff
    }
    IconButton(onClick = {
        onClick()
//        onEventHandler.invoke(NewGameEvent.OnDonePressed)
    }) {
        Icon(
            icon,
            "",
            tint = color,
        )
    }
}