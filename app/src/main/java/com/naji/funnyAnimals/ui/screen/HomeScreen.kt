package com.naji.funnyAnimals.ui.screen

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.material.icons.filled.MusicOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavController
import com.naji.funnyAnimals.R
import com.naji.funnyAnimals.data.CardHome
import com.naji.funnyAnimals.data.HomeCardData
import com.naji.funnyAnimals.ui.theme.Black
import com.naji.funnyAnimals.ui.theme.Orange50
import com.naji.funnyAnimals.ui.theme.Orange500
import com.naji.funnyAnimals.ui.theme.Orange900
import com.naji.funnyAnimals.ui.util.HandleResourceOnLifeCycle


@Composable
fun HomeScreen(
    navController: NavController,
    lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current,
    viewModel: ViewModel
) {

    val context = LocalContext.current
    HandleResourceOnLifeCycle(lifecycleOwner, {}, { stopSound(context) })

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(30.dp)
            .fillMaxSize()
    ) {
        val isMusicPlay: Boolean by viewModel.backgroundMusicPlaying.observeAsState(true)

        Header(musicIconClickHandler = { viewModel.musicIconClickHandler(it) }, isMusicPlay)
        Spacer(modifier = Modifier.height(24.dp))
        GridHome(HomeCardData.HomeCardList, navController = navController)
    }
}

@Composable
fun GridHome(cardList: List<CardHome>, navController: NavController) {

    LazyColumn() {
        items(items = cardList.chunked(2)) { rowItems ->
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.padding(horizontal = 8.dp),
            )
            {
                for (item in rowItems) {
                    Box(

                        modifier = Modifier
                            .animateContentSize()
                            .padding(1.dp)
                            .weight(1f)
                            .aspectRatio(1f)
                            .background(
                                color = item.background,
                                shape = MaterialTheme.shapes.medium
                            ),
                        Alignment.Center
                    ) {

                        HomeCard(item, navController)
                    }

                }
            }
            Spacer(Modifier.height(8.dp))
        }

    }
}

@Composable
fun Header(musicIconClickHandler: (Boolean) -> Unit, isMusicPlay: Boolean) {

    val context = LocalContext.current

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(all = 8.dp)
    )
    {
        Image(
            painter = painterResource(id = R.drawable.animal_lion),
            contentDescription = stringResource(R.string.content_description_main_icon),
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
                .background(Orange50)
                .padding(all = 6.dp),


            )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(R.string.home_title),
            color = Black,
            style = MaterialTheme.typography.body2,
            modifier = Modifier.defaultMinSize(50.dp),
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = Modifier.height(4.dp))
        Row() {

            val icon = if (isMusicPlay) {
                playSound(context = context, R.raw.music_back)
                Icons.Filled.MusicNote
            } else {
                stopSound(context = context)
                Icons.Filled.MusicOff
            }

            Icon(icon,
                contentDescription = "music on", tint = Orange900,
                modifier = Modifier
                    .clickable {
                        musicIconClickHandler(isMusicPlay)
                    }

            )

            Text(
                text = stringResource(R.string.home_body),
                color = Orange500,
                style = MaterialTheme.typography.body2,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold

            )


        }
    }
}


@Composable
fun HomeCard(cardHome: CardHome, navController: NavController) {

    val verySmallPadding = dimensionResource(R.dimen._4sdp)
    val smallPadding = dimensionResource(R.dimen._4sdp)
    val mediumPadding = dimensionResource(R.dimen._4sdp)
    val largePadding = dimensionResource(R.dimen._4sdp)
    val imageSize = dimensionResource(R.dimen._40sdp)


    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(all = mediumPadding)
            .clickable { navController.navigate(cardHome.route) }
    ) {
        Image(
            painter = painterResource(id = cardHome.icon),
            contentDescription = "this is sample picture",
            modifier = Modifier
                .size(imageSize)
                .clip(CircleShape)
                .background(cardHome.backgroundIcon)
                .padding(verySmallPadding)
        )
        Spacer(modifier = Modifier.height(largePadding))

        Text(
            text = cardHome.title,
            color = cardHome.titleColor,
            style = MaterialTheme.typography.subtitle2,
            textAlign = TextAlign.Right,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = cardHome.description,
            Modifier.padding(all = smallPadding),
            maxLines = 1,
            style = MaterialTheme.typography.overline,

            )
    }
}

