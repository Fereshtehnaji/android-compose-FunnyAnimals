package com.naji.funnyAnimals.ui.screen

import android.content.Context
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.naji.funnyAnimals.R
import com.naji.funnyAnimals.data.Animal
import com.naji.funnyAnimals.data.TYPE
import com.naji.funnyAnimals.ui.util.MusicManager

@Composable
fun AnimalItem(animal: Animal, viewModel: WildAnimalViewModel, type: TYPE) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(all = 8.dp)
    ) {

        ShowImage(animal, viewModel, type)


        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = " ${animal.name}",
            color = MaterialTheme.colors.secondaryVariant,
            style = MaterialTheme.typography.subtitle2,
            modifier = Modifier.defaultMinSize(40.dp),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun ShowImage(animal: Animal, viewModel: WildAnimalViewModel, type: TYPE) {
    val context = LocalContext.current

    var isClicked by remember { mutableStateOf(false) }
    isClicked = animal.isClicked


    val angle = GetAngle(isClicked = isClicked)
    val imageSize = dimensionResource(id = R.dimen._70sdp)

    Box(contentAlignment = Alignment.Center) {
        Image(
            painter = painterResource(animal.picture),
            contentDescription = "this is sample picture",
            modifier = Modifier
                .size(imageSize)
//                .clip(CircleShape)
                .clickable {
                    stopSound(context = context)
                    isClicked = !isClicked
                    animal.isClicked = isClicked
                    viewModel.clickOnItem(animal, type = type)
                    playSound(context = context, animal.sound)
                }
                .rotate(angle)

        )

        if (isClicked)
            Image(
                painter = painterResource(animal.label),
                contentDescription = "this is sample picture",
                modifier = Modifier
                    .size(70.dp, 70.dp)
                    .padding(top = 25.dp),

                )
    }
}


fun playSound(context: Context, sound: Int) {

    MusicManager.getInstance(context).play(sound)
}

fun stopSound(context: Context) {

    MusicManager.getInstance(context).stop()
}

@Composable
fun GetAngle(isClicked: Boolean): Float {
    val infiniteTransition = rememberInfiniteTransition()

    val shake by infiniteTransition.animateFloat(
        initialValue = -30F,
        targetValue = 30F,
        animationSpec = infiniteRepeatable(
            animation = tween(2500, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )


    val rotationAngle by animateFloatAsState(
        targetValue = if (isClicked) 360F else 0f,
        animationSpec = tween(durationMillis = 2500),
        finishedListener = {
        }

    )


    return if (isClicked) rotationAngle else shake
}


@Composable
fun GetScreenWidth(): Int {
    val configuration = LocalConfiguration.current
    return configuration.screenWidthDp
}