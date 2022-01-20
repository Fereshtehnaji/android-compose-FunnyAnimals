package com.naji.funnyAnimals.ui.screen

import android.content.Context
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
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

        Box(contentAlignment = Alignment.Center) {

            ShowImage(animal, onClickHandler)

            Spacer(modifier = Modifier.height(4.dp))

            ShowLabel(animal.label, visibility = animal.isClicked)
        }
    }
}

@Composable
fun ShowImage(animal: Animal, onClickHandler: (Animal) -> Unit) {

    val context = LocalContext.current
    val imageSize = dimensionResource(id = R.dimen._70sdp)
    val animationDegree = GetRotateAnimationDegree(isClicked = animal.isClicked)
    val scale = GetScaleAnimation(isClicked = animal.isClicked)

    Image(
        painter = painterResource(animal.picture),
        contentDescription = "",
        modifier = Modifier
            .size(imageSize)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) {
                stopSound(context = context)
                playSound(context = context, sound = animal.sound)
                onClickHandler(animal)
            }

            .scale(scale)
            .rotate(animationDegree)
//            .graphicsLayer(rotationZ = angle, scaleX = scale, scaleY = scale, translationX = 0.5f)
    )
}


@Composable
fun ShowLabel(label: Int, visibility: Boolean) {

    val imageSize = dimensionResource(id = R.dimen._70sdp)
    val paddingTop = dimensionResource(id = R.dimen._26sdp)

//    AnimatedVisibility(
//        visible = visibility,
//        enter = expandHorizontally(),
//        exit = shrinkHorizontally() + fadeOut()
//    ) {
    if (visibility)
        Image(
            painter = painterResource(label),
            contentDescription = "",
            modifier = Modifier
                .size(imageSize, imageSize)
                .padding(top = paddingTop), alignment = Alignment.BottomCenter

        )
//    }


}

@Composable
fun GetScaleAnimation(isClicked: Boolean): Float {
    val clickedAnimation by animateFloatAsState(
        targetValue = if (isClicked) 1.5F else 1f,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioHighBouncy,
            stiffness = Spring.StiffnessVeryLow
        )

//                animationSpec = repeatable(
//            iterations = 1,
//            animation = tween(
//                durationMillis = 500,
//                easing = FastOutSlowInEasing
//            ),
//            repeatMode = RepeatMode.Reverse
//        ), finishedListener = {
//        }
    )
    return clickedAnimation
}

@Composable
fun GetRotateAnimationDegree(isClicked: Boolean): Float {
    val infiniteTransition = rememberInfiniteTransition()

    val rotateInDegreeAnimation by infiniteTransition.animateFloat(
        initialValue = 20F,
        targetValue = -20F,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1500,
                easing = FastOutSlowInEasing
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

    return if (isClicked) rotateInDegreeAnimation else 0f
}

fun playSound(context: Context, sound: Int) {

    MusicManager.getInstance(context).play(sound)
}

fun stopSound(context: Context) {

    MusicManager.getInstance(context).stop()
}

@Composable
fun GetScreenWidth(): Int {
    val configuration = LocalConfiguration.current
    return configuration.screenWidthDp
}