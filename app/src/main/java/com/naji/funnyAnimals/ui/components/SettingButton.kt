package com.naji.funnyAnimals.ui.components

import android.widget.ImageButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.naji.funnyAnimals.R

@Composable
fun SettingButton(onClick: () -> Unit , color: Color){
    val icon = ImageVector.vectorResource(id = R.drawable.ic_settings)
    IconButton(onClick = {
        onClick()
    }) {
        Icon(
            icon,
            "",
            tint = color,
        )
    }
}