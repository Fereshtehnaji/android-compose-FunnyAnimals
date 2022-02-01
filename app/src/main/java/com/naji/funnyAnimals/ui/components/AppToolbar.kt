package com.naji.funnyAnimals.ui.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.naji.funnyAnimals.ui.theme.LightBlue200

@Composable
fun AppToolbar(
    modifier: Modifier,
    title: String,
    icon1: @Composable (() -> Unit)? = null,
    icon2: @Composable (() -> Unit)? = null,
    icon3: @Composable (() -> Unit)? = null,
    icon4: @Composable (() -> Unit)? = null,
    backHandler: () -> Unit
) {

    RightTopAppBar(modifier = modifier,
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = Color.White,
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.subtitle1,
                color = if (MaterialTheme.colors.isLight) {
                    Color.White
                } else {
                    LightBlue200
                },
                maxLines = 1,
                textAlign = TextAlign.Center,
            )

        },
        actions = {
            icon1?.invoke()
            icon2?.invoke()
            icon3?.invoke()
            icon4?.invoke()
        },
        navigationIcon = {
            IconButton(onClick = {backHandler()}) {
                Icon(Icons.Filled.ArrowForward, null)
            }
        }
    )

}


