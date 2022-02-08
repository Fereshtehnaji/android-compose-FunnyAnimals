package com.naji.funnyAnimals.ui.screen

import android.content.Context
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.naji.funnyAnimals.R
import com.naji.funnyAnimals.data.Animal
import com.naji.funnyAnimals.data.animalenum.TYPE
import com.naji.funnyAnimals.ui.theme.*
import com.naji.funnyAnimals.ui.util.MusicManager


@Composable
fun AnimalItem(animal: Animal, onClickHandler: (Animal) -> Unit,type:TYPE) {

    val context = LocalContext.current

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(all = dimensionResource(id = R.dimen._6sdp))
    ) {

        Box(contentAlignment = Alignment.Center,
            modifier = Modifier
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null
                ) {
                    playSound(context = context, sound = animal.sound)
                    onClickHandler(animal)
                }
        ) {

            ItemAnimation(animal.picture, animal.isClicked,type)

            ShowLabel(animal.label, visibility = animal.isClicked)
        }
    }
}

@Composable
fun ItemAnimation(image: Int, isClicked: Boolean,type:TYPE) {

    val animationDegree = getRotateAnimationDegree(isClicked)
    val scale = getScaleAnimation(isClicked)

    ShowImage(image, animationDegree, scale,type)
}

@Composable
fun ShowImage(image: Int, rotationDegrees: Float = 0f, scaleValue: Float = 0f,type:TYPE) {

    val imageSize = dimensionResource(id = R.dimen._60sdp)

    Image(
        painter = painterResource(image),
        contentDescription = "",
        modifier = Modifier
            .size(imageSize)
            .scale(scaleValue)
            .rotate(rotationDegrees)
            .clip(CircleShape)
            .background(colorBackground(type = type))
            .padding(all = 4.dp)
//            .graphicsLayer(rotationZ = angle, scaleX = scale, scaleY = scale, translationX = 0.5f)
    )

}

@Composable
fun colorBackground(type:TYPE) : Color{
   return when (type){
        TYPE.ANIMAL -> Green200
        TYPE.BUG -> Yellow300
        TYPE.BIRD -> Orange200
        TYPE.AQUATIC -> Cyan200
   }
}


@Composable
fun ShowLabel(label: Int, visibility: Boolean) {

    val imageSize = dimensionResource(id = R.dimen._60sdp)

    if (visibility)
        Image(
            painter = painterResource(label),
            contentDescription = "",
            modifier = Modifier
                .size(imageSize),alignment = Alignment.BottomCenter

        )
}

@Composable
fun getScaleAnimation(isClicked: Boolean): Float {
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
fun getRotateAnimationDegree(isClicked: Boolean): Float {
    val infiniteTransition = rememberInfiniteTransition()

    val rotateInDegreeAnimation by infiniteTransition.animateFloat(
        initialValue = 0F,
        targetValue = 40F,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1500,
                easing = FastOutSlowInEasing
            ),
            repeatMode = RepeatMode.Reverse
        )
    )

//    val rotateAnim by animateFloatAsState(
//        targetValue = if (isClicked) 360F else 0f,
//        animationSpec = tween(durationMillis = 2500),
//        finishedListener = {
//        }

//    )

    return if (isClicked) rotateInDegreeAnimation else 0f
}



fun playSound(context: Context, sound: Int) {

    MusicManager.getInstance(context).play(sound)
}

fun stopSound(context: Context) {

    MusicManager.getInstance(context).stop()
}

@Composable
fun getScreenWidth(): Int {
    val configuration = LocalConfiguration.current
    return configuration.screenWidthDp
}