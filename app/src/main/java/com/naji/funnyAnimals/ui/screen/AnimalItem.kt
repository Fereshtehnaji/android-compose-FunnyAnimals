package com.naji.funnyAnimals.ui.screen

import android.content.Context
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.naji.funnyAnimals.R
import com.naji.funnyAnimals.data.Animal
import com.naji.funnyAnimals.data.animalenum.Language
import com.naji.funnyAnimals.data.animalenum.TYPE
import com.naji.funnyAnimals.ui.theme.*
import com.naji.funnyAnimals.ui.util.MusicManager


@Composable
fun AnimalItem(animal: Animal, onClickHandler: (Animal) -> Unit, type: TYPE) {

    val context = LocalContext.current

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(all = dimensionResource(id = R.dimen._6sdp))
    ) {

        Box(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null
                ) {
                    playSound(context = context, sound = animal.sound)
                    onClickHandler(animal)
                }
        ) {

            ItemAnimation(animal.shape, animal.isClicked, type)

            if (animal.isClicked) {
                val imageSize = dimensionResource(id = R.dimen._60sdp)
                val title = if (animal.language == Language.FA.nameType)
                    animal.title else animal.name
                Text(
                    text = title,
                    color = Black,
                    style = AnimalTypography.subtitle2,
                    modifier = Modifier
                        .background(color = Orange800, shape = RoundedCornerShape(20.dp))

                        .defaultMinSize(imageSize)
                        .align(Alignment.BottomCenter),
                    textAlign = TextAlign.Center,
                )
            }
//            ShowLabel(animal.title, visibility = animal.isClicked)
        }
    }
}

@Composable
fun ItemAnimation(image: Int, isClicked: Boolean, type: TYPE) {

    val animationDegree = getRotateAnimationDegree(isClicked)
    val scale = getScaleAnimation(isClicked)

    ShowImage(image, animationDegree, scale, type)
}

@Composable
fun ShowImage(image: Int, rotationDegrees: Float = 0f, scaleValue: Float = 0f, type: TYPE) {

    val imageSize = dimensionResource(id = R.dimen._60sdp)
    val backColor = remember { getColorBackground(type = type) }
    Image(
        painter = rememberImagePainter(image),
        contentDescription = "",
        modifier = Modifier
            .size(imageSize)
            .scale(scaleValue)
            .rotate(remember { rotationDegrees })
            .clip(CircleShape)
            .background(backColor)
            .padding(all = 4.dp),

        )

}

fun getColorBackground(type: TYPE): Color {
    return when (type) {
        TYPE.ANIMAL -> Green200
        TYPE.BUG -> Yellow300
        TYPE.BIRD -> Orange200
        TYPE.AQUATIC -> Cyan200
    }
}

@Composable
fun getScaleAnimation(isClicked: Boolean): Float {

    val clickedAnimation by animateFloatAsState(
        targetValue = if (isClicked) 1.5F else 1f,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioHighBouncy,
            stiffness = Spring.StiffnessVeryLow
        )
    )
    return clickedAnimation
}

@Composable
fun getRotateAnimationDegree(isClicked: Boolean): Float {
    val infiniteTransition = rememberInfiniteTransition()
    val hesitateEasing = CubicBezierEasing(0.2f, 0.2f, 0.8F, 0.8f)

    val rotateInDegreeAnimation by infiniteTransition.animateFloat(

        initialValue = -20F,
        targetValue = 20F,
        animationSpec = InfiniteRepeatableSpec(
            animation = tween(1000, easing = hesitateEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    return if (isClicked) rotateInDegreeAnimation else 0f
}


fun playSound(context: Context, sound: Int) {

    MusicManager.getInstance(context).play(sound)
}

fun stopSound(context: Context) {

    MusicManager.getInstance(context).stop()
}

