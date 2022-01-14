package com.naji.funnyAnimals.ui.util

import android.content.Context
import android.content.Intent
import com.naji.funnyAnimals.ServiceCommand

fun Context.startMusicService(command: String) {
    val intent = Intent(this, MusicService::class.java)

    if (command == ServiceCommand.START.nameType) {
        this.startService(intent)
    } else if (command == ServiceCommand.STOP.nameType) {
        this.stopService(intent)
    }
}