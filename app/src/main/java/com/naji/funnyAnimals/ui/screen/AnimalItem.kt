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

    val context = LocalContext.current

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(all = dimensionResource(id = R.dimen._8sdp))
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

            ItemAnimation(animal.picture, animal.isClicked)

            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen._4sdp)))

            ShowLabel(animal.label, visibility = animal.isClicked)
        }
    }
}

@Composable
fun ItemAnimation(image: Int, isClicked: Boolean) {

    val animationDegree = GetRotateAnimationDegree(isClicked)
    val scale = GetScaleAnimation(isClicked)

    ShowImage(image, animationDegree, scale)
}

@Composable
fun ShowImage(image: Int, rotationDegrees: Float = 0f, scaleValue: Float = 0f) {

    val imageSize = dimensionResource(id = R.dimen._70sdp)

    Image(
        painter = painterResource(image),
        contentDescription = "",
        modifier = Modifier
            .size(imageSize)
            .scale(scaleValue)
            .rotate(rotationDegrees)
//            .graphicsLayer(rotationZ = angle, scaleX = scale, scaleY = scale, translationX = 0.5f)
    )

}


@Composable
fun ShowLabel(label: Int, visibility: Boolean) {

    val imageSize = dimensionResource(id = R.dimen._70sdp)
    val paddingTop = dimensionResource(id = R.dimen._26sdp)

    if (visibility)
        Image(
            painter = painterResource(label),
            contentDescription = "",
            modifier = Modifier
                .size(imageSize, imageSize)
                .padding(top = paddingTop), alignment = Alignment.BottomCenter

        )
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

//    val rotateAnim by animateFloatAsState(
//        targetValue = if (isClicked) 360F else 0f,
//        animationSpec = tween(durationMillis = 2500),
//        finishedListener = {
//        }

//    )

    return if (isClicked) rotateInDegreeAnimation else 0f
}

/*
 enum class ComponentState { Pressed, Released }
@Composable
fun MyTest(isClicked: Boolean) {

    var isAnimated by remember { mutableStateOf(false) }
    val transition = updateTransition(targetState = isAnimated, label = "")

    val rocketOffset by transition.animateOffset(transitionSpec = {
        if (this.targetState) {
            tween(1000)
        } else {
            tween(3000)
            //spring(dampingRatio = Spring.DampingRatioLowBouncy) - I want this spec too
        }

    }, label = "rocket offset") { animated ->
        if (animated) Offset(200f, 0f) else Offset(200f, 500f)
    }

    var useRed by remember { mutableStateOf(false) }
    var toState by remember { mutableStateOf(ComponentState.Released) }

    val modifier = Modifier.pointerInput(Unit) {
        detectTapGestures(
            onPress = {
                toState = ComponentState.Pressed
                tryAwaitRelease()
                toState = ComponentState.Released
            }
        )
    }

// Defines a transition of `ComponentState`, and updates the transition when the provided
// [targetState] changes. The tran
// sition will run all of the child animations towards the new
// [targetState] in response to the [targetState] change.
    val transition: Transition<Float> = GetRotateAnimationDegree(isClicked = isClicked)
// Defines a float animation as a child animation the transition. The current animation value
// can be read from the returned State<Float>.
    val scale: Float by transition.animateFloat(
        // Defines a transition spec that uses the same low-stiffness spring for *all*
        // transitions of this float, no matter what the target is.
        transitionSpec = { spring(stiffness = 50f) }, label = ""
    ) { state ->
        // This code block declares a mapping from state to value.
        if (state ==0f && isClicked) 2f else 1f
    }

// Defines a color animation as a child animation of the transition.
    val color: Color by transition.animateColor(
        transitionSpec = {
            when {
                ComponentState.Pressed isTransitioningTo ComponentState.Released ->
                    // Uses spring for the transition going from pressed to released
                    spring(stiffness = 50f)
                else ->
                    // Uses tween for all the other transitions. (In this case there is
                    // only one other transition. i.e. released -> pressed.)
                    tween(durationMillis = 500)
            }
        }
    ) { state ->
        when (state) {
            // Similar to the float animation, we need to declare the target values
            // for each state. In this code block we can access theme colors.
            ComponentState.Pressed -> MaterialTheme.colors.primary
            // We can also have the target value depend on other mutableStates,
            // such as `useRed` here. Whenever the target value changes, transition
            // will automatically animate to the new value even if it has already
            // arrived at its target state.
            ComponentState.Released -> if (useRed) Color.Red else MaterialTheme.colors.secondary
        }
    }
    Column {
        Button(
            modifier = Modifier.padding(10.dp).align(Alignment.CenterHorizontally),
            onClick = { useRed = !useRed }
        ) {
            Text("Change Color")
        }
        Box(
            modifier.fillMaxSize().wrapContentSize(Alignment.Center)
                .size((100 * scale).dp).background(color)
        )
    }

}
*/

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