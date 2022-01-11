package com.naji.funnyAnimals.ui.screen

import android.content.Context
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.naji.funnyAnimals.R
import com.naji.funnyAnimals.data.Animal
import com.naji.funnyAnimals.ui.util.MusicManager

@Composable
fun AnimalItem(animal: Animal, onClickHandler: (Animal) -> Unit) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(all = 8.dp)
    ) {

        ShowImage(animal, onClickHandler)

        Spacer(modifier = Modifier.height(4.dp))

//        ShowNameText(animal)

    }
}

@Composable
fun ShowImage(animal: Animal, onClickHandler: (Animal) -> Unit) {

    val context = LocalContext.current
    val imageSize = dimensionResource(id = R.dimen._70sdp)


    val angle = GetAnimationType(isClicked = animal.isClicked)

    val scale = GetScaleAnimation(isClicked = animal.isClicked)

    Box(contentAlignment = Alignment.Center) {
        Image(
            painter = painterResource(animal.picture),
            contentDescription = "this is sample picture",
            modifier = Modifier
                .size(imageSize)
                .clickable(   interactionSource = remember { MutableInteractionSource() },
                    indication = null) {
                    stopSound(context = context)
                    playSound(context = context, sound = animal.sound)
                    onClickHandler(animal)
                }

                .rotate(angle)
                .scale(scale)
        )
        Spacer(modifier = Modifier.height(4.dp))


        if (animal.isClicked)
            ShowLabel(animal.label)
    }
}


@Composable
fun ShowNameText(animal: Animal) {
    Text(
        text = " ${animal.name}",
        color = MaterialTheme.colors.secondaryVariant,
        style = MaterialTheme.typography.subtitle2,
        modifier = Modifier.defaultMinSize(40.dp),
        textAlign = TextAlign.Center
    )
}


fun playSound(context: Context, sound: Int) {

    MusicManager.getInstance(context).play(sound)
}

fun stopSound(context: Context) {

    MusicManager.getInstance(context).stop()
}


@Composable
fun ShowLabel(label: Int) {
    Image(
        painter = painterResource(label),
        contentDescription = "this is sample picture",
        modifier = Modifier
            .size(70.dp, 70.dp)
            .padding(top = 25.dp),

        )
}

@Composable
fun GetScaleAnimation(isClicked: Boolean): Float {
    val clickedAnimation by animateFloatAsState(
        targetValue = if (isClicked) 1.5F else 1f,
        animationSpec = repeatable(
            iterations = 1,
            animation = tween(
                durationMillis = 1000,
                easing = CubicBezierEasing(0.4f, 0.0f, 0.8f, 0.0f)
            ),
            repeatMode = RepeatMode.Reverse
        ), finishedListener = {
        }
    )
    return clickedAnimation
}

@Composable
fun GetAnimationType(isClicked: Boolean): Float {
    val infiniteTransition = rememberInfiniteTransition()

    val rotateInDegreeAnimation by infiniteTransition.animateFloat(
        initialValue = 20F,
        targetValue = -20F,
        animationSpec = infiniteRepeatable(
            animation = tween(
                1500, easing = FastOutSlowInEasing
            ),
            repeatMode = RepeatMode.Reverse
        )
    )


    val rotateAnim by animateFloatAsState(
        targetValue = if (isClicked) 360F else 0f,
        animationSpec = tween(durationMillis = 2500),
        finishedListener = {
        }

    )

    return rotateInDegreeAnimation
}


@Composable
fun GetScreenWidth(): Int {
    val configuration = LocalConfiguration.current
    return configuration.screenWidthDp
}