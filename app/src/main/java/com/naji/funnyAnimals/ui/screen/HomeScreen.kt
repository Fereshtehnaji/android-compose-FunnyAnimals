package com.naji.funnyAnimals.ui.screen

import androidx.compose.animation.animateColor
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.naji.funnyAnimals.R
import com.naji.funnyAnimals.data.CardHome
import com.naji.funnyAnimals.data.HomeCardData
import com.naji.funnyAnimals.ui.components.AppToolbar
import com.naji.funnyAnimals.ui.components.LanguageButton
import com.naji.funnyAnimals.ui.components.MusicButton
import com.naji.funnyAnimals.ui.theme.*
import kotlinx.coroutines.delay

@ExperimentalComposeUiApi
@Composable
fun HomeScreen(navController: NavController, viewModel: ViewModel) {


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {


        val isMusicPlay: Boolean by
        viewModel.backgroundMusicPlaying.observeAsState(initial = viewModel.isMusicPlaying())

        val languageLabel: String by
        viewModel.appLanguage.observeAsState(initial = viewModel.getLanguageOfApp())

        Header(
            onClickMusicButton = { viewModel.musicButtonHandler() },
            onClickLanguageButton = { viewModel.languageButtonHandler() },
            isMusicPlay, languageLabel
        )

        Spacer(modifier = Modifier.height(dimensionResource(R.dimen._20sdp)))

        GridHome(HomeCardData.HomeCardList, navController = navController)
    }
}


@Composable
fun Header(
    onClickMusicButton: () -> Unit,
    onClickLanguageButton: () -> Unit,
    isMusicPlay: Boolean, language: String
) {

    val topPadding = dimensionResource(R.dimen._8sdp)
    val startPadding = dimensionResource(R.dimen._8sdp)


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(top = topPadding, start = startPadding)
    ) {

        AppToolbar(modifier = Modifier.height(dimensionResource(id = R.dimen._50sdp)),
            title = "",
            backgroundColor = White,
            icon1 = {
                MusicButton(
                    onClick = { onClickMusicButton() },
                    isMusicPlay, Green500
                )
            },
            icon2 = {
                LanguageButton(
                    onClick = { onClickLanguageButton() },
                    language = language, Cyan500
                )
            })


        Image(
            painter = painterResource(id = R.drawable.animal_lion),
            contentDescription = stringResource(R.string.content_description_main_icon),
            modifier = Modifier
                .size(dimensionResource(id = R.dimen._80sdp))
                .clip(CircleShape)
                .background(Orange50)
                .padding(all = dimensionResource(id = R.dimen._6sdp)),
        )

        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen._16sdp)))

        Text(
            text = stringResource(R.string.home_title),
            color = Orange500,
            style = AnimalTypography.h5,
            modifier = Modifier.defaultMinSize(dimensionResource(id = R.dimen._50sdp)),
            textAlign = TextAlign.Center,
        )

        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen._4sdp)))


        Text(
            text = stringResource(R.string.home_body),
            color = Black,
            style = AnimalTypography.subtitle2,
            textAlign = TextAlign.Center,
        )


    }
}

enum class BounceState { Pressed, Released }


@ExperimentalComposeUiApi
@Composable
fun GridHome(cardList: List<CardHome>, navController: NavController) {

    val startPadding = dimensionResource(R.dimen._28sdp)
    val endPadding = dimensionResource(R.dimen._28sdp)

    LazyColumn(
        modifier = Modifier
            .padding(start = startPadding, end = endPadding)
    ) {

        items(items = cardList.chunked(2)) { rowItems ->
            Row(
                horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen._16sdp)),
            )
            {
                for (item in rowItems) {

                    var currentState: BounceState by remember { mutableStateOf(BounceState.Released) }

                    val transition =
                        updateTransition(targetState = currentState, label = "animation")
                    val scale: Float by transition.animateFloat(
                        transitionSpec = {
                            tween(
                                durationMillis = 50,
                                easing = FastOutSlowInEasing
                            )
                        }, label = ""
                    ) { state ->

                        if (state == BounceState.Pressed) {
                            0.80f

                        } else {
                            1f
                        }
                    }

                    val backColor: Color by transition.animateColor(
                        transitionSpec = { spring(stiffness = 900f) }, label = ""
                    ) { state ->

                        if (state == BounceState.Pressed) {
                            item.backgroundDark

                        } else {
                            item.background
                        }
                    }
                    Box(
                        modifier = Modifier
                            .animateContentSize()
                            .weight(1f)
                            .background(color = backColor, shape = RoundedCornerShape(20.dp))
                            .clickable { navController.navigate(item.route) }
                            .pointerInput(Unit) {
                                detectTapGestures(
                                    onPress = {
                                        currentState = BounceState.Pressed
                                        tryAwaitRelease()
                                        currentState = BounceState.Released
                                        delay(100)
                                        navController.navigate(item.route)
                                    },
                                )
                            }
                            .scale(scale = scale),
                        Alignment.Center,

                        ) {

                        HomeCard(item)
                    }

                }
            }
            Spacer(Modifier.height(dimensionResource(id = R.dimen._16sdp)))
        }

    }
}


@Composable
fun HomeCard(cardHome: CardHome) {

    val verySmallPadding = dimensionResource(R.dimen._4sdp)
    val mediumPadding = dimensionResource(R.dimen._6sdp)
    val largePadding = dimensionResource(R.dimen._14sdp)
    val imageSize = dimensionResource(R.dimen._70sdp)


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {

        Spacer(modifier = Modifier.height(largePadding))

        Image(
            painter = painterResource(id = cardHome.icon),
            contentDescription = null,
            modifier = Modifier
                .size(imageSize)
                .clip(CircleShape)
                .background(cardHome.backgroundIcon)
                .padding(bottom = verySmallPadding)
        )
        Spacer(modifier = Modifier.height(mediumPadding))

        Text(
            text = cardHome.title,
            color = cardHome.titleColor,
            style = AnimalTypography.caption,
            textAlign = TextAlign.Right,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(largePadding))

    }
}


@ExperimentalComposeUiApi
@Preview
@Composable
fun PreviewHomeScreen() {
    val context = LocalContext.current

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(dimensionResource(id = R.dimen._30sdp))
            .fillMaxSize()
    ) {
        Header(
            onClickMusicButton = {},
            onClickLanguageButton = {},
            true, "fa"
        )

        Spacer(modifier = Modifier.height(24.dp))

        GridHome(HomeCardData.HomeCardList, navController = NavController(context))
    }
}
