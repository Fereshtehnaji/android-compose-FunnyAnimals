package com.naji.funnyAnimals.ui.screen

import android.content.Context
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.naji.funnyAnimals.R
import com.naji.funnyAnimals.data.CardHome
import com.naji.funnyAnimals.data.HomeCardData
import com.naji.funnyAnimals.data.animalenum.Language
import com.naji.funnyAnimals.data.animalenum.ServiceCommand
import com.naji.funnyAnimals.ui.theme.*
import com.naji.funnyAnimals.ui.util.startMusicService


@Preview
@Composable
fun PreviewHomeScreen() {
    val context = LocalContext.current

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(30.dp)
            .fillMaxSize()
    ) {
        Header(
            musicIconClick = {},
            languageIconClick = {},
            true, "fa"
        )

        Spacer(modifier = Modifier.height(24.dp))

        GridHome(HomeCardData.HomeCardList, navController = NavController(context))
    }
}

@Composable
fun HomeScreen(navController: NavController, viewModel: ViewModel) {

    val padding = dimensionResource(R.dimen._30sdp)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(top = padding, start = padding, end = padding)
            .fillMaxSize()
    ) {


        val isMusicPlay: Boolean by viewModel.backgroundMusicPlaying.observeAsState(initial = viewModel.isMusicPlaying())
        val languageLabel: String by viewModel.appLanguage.observeAsState(initial = viewModel.getLanguageOfApp())

        Header(
            musicIconClick = { viewModel.musicIconClickHandler() },
            languageIconClick = { viewModel.languageIconHandler() },
            isMusicPlay, languageLabel
        )

        Spacer(modifier = Modifier.height(24.dp))

        GridHome(HomeCardData.HomeCardList, navController = navController)
    }
}

@Composable
fun Header(
    musicIconClick: () -> Unit,
    languageIconClick: () -> Unit,
    isMusicPlay: Boolean, language: String
) {

    val context = LocalContext.current

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    )
    {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {

            val musicIcon = GetMusicIcon(isMusicPlay, context)
            Icon(musicIcon,
                contentDescription = "music on", tint = Green500,
                modifier = Modifier
                    .padding(end = dimensionResource(id = R.dimen._4sdp))
                    .clickable { musicIconClick() }
            )

            val languageIcon = GetLanguageIcon(language = language)
            Icon(languageIcon,
                contentDescription = "change language en to fa", tint = Cyan500,
                modifier = Modifier
                    .clickable { languageIconClick() }
            )

        }
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

@Composable
fun GridHome(cardList: List<CardHome>, navController: NavController) {

    LazyColumn {
        items(items = cardList.chunked(2)) { rowItems ->
            Row(
                horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen._16sdp)),
            )
            {
                for (item in rowItems) {
                    Box(
                        modifier = Modifier
                            .animateContentSize()
                            .weight(1f)
                            .background(
                                color = item.background,
                                shape = RoundedCornerShape(20.dp)
                            )
                            .clickable {
                                navController.navigate(item.route)
                            },
                        Alignment.Center
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
fun GetMusicIcon(musicPlay: Boolean, context: Context): ImageVector {

    return if (musicPlay) {
        context.startMusicService(ServiceCommand.START.nameType)
        Icons.Filled.MusicNote
    } else {
        context.startMusicService(ServiceCommand.STOP.nameType)
        Icons.Filled.MusicOff
    }
}

@Composable
fun GetLanguageIcon(language: String): ImageVector {
    return if (language == Language.FA.nameType)
        ImageVector.vectorResource(id = R.drawable.ic_fa)
    else ImageVector.vectorResource(id = R.drawable.ic_en)

}


@Composable
fun HomeCard(cardHome: CardHome) {

    val verySmallPadding = dimensionResource(R.dimen._4sdp)
    val mediumPadding = dimensionResource(R.dimen._8sdp)
    val largePadding = dimensionResource(R.dimen._16sdp)
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
            style = AnimalTypography.h5,
            textAlign = TextAlign.Right,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(largePadding))

    }
}

