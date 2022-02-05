package com.naji.funnyAnimals.ui.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.naji.funnyAnimals.R
import com.naji.funnyAnimals.data.animalenum.Language

@Composable
fun LanguageButton(onClick: () -> Unit, language: String, color: Color) {
    val icon = if (language == Language.FA.nameType) {
        ImageVector.vectorResource(id = R.drawable.ic_fa)
    } else {
        ImageVector.vectorResource(id = R.drawable.ic_en)
    }
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