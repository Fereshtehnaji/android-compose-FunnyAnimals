package com.naji.funnyAnimals.ui.screen

import android.content.Context
import android.media.MediaPlayer
import androidx.compose.animation.core.*
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.naji.funnyAnimals.R
import com.naji.funnyAnimals.data.Animal
import com.naji.funnyAnimals.data.AnimalData
import com.naji.funnyAnimals.ui.util.MusicManager


const val SCREEN_CONST = 120


@Composable
fun WildScreen(viewModel: WildAnimalViewModel) {

    viewModel.init()

    val animalList by viewModel.getAnimalList().observeAsState()

    animalList?.let { AnimalGrid(animals = it, viewModel) }
}

@Composable
fun AnimalGrid(animals: List<Animal>, viewModel: WildAnimalViewModel) {

    val numberOfItemsByRow = GetScreenWidth() / SCREEN_CONST

    LazyColumn(modifier = Modifier.padding(all = 8.dp)) {


        items(items = animals.chunked(numberOfItemsByRow)) { rowItems ->
            Row(
                horizontalArrangement = Arrangement.spacedBy(14.dp),
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {

                for (animal in rowItems) {
                    AnimalItem(animal = animal, viewModel)
                }
            }
            Spacer(Modifier.height(14.dp))
        }

    }
}

@Composable
fun AnimalGrid2(animals: List<Animal>) {

//        LazyVerticalGrid(cells = GridCells.Fixed(4)) {
//            itemsIndexed(animals) { row, item->
//                AnimalItem(animal = item)
//            }
//        }
}


@Composable
fun AnimalItem(animal: Animal, viewModel: WildAnimalViewModel) {
    val context = LocalContext.current
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(all = 8.dp)
    ) {

        var isClicked by remember { mutableStateOf(false) }
        isClicked = animal.animate


        val infiniteTransition = rememberInfiniteTransition()
        val angle by infiniteTransition.animateFloat(
            initialValue = 0F,
            targetValue = if (isClicked) 360F else 0F,
            animationSpec = infiniteRepeatable(
                animation = tween(2000, easing = LinearEasing)
            )
        )
        Image(
            painter = painterResource(animal.picture),
            contentDescription = "this is sample picture",
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
                .clickable {

                    isClicked = !isClicked
                    animal.animate = isClicked
                    playSound(context = context, animal.sound)
                    viewModel.clickOnItem(animal)
                }
                .rotate(angle)

        )
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

fun playSound(context: Context, sound: Int) {

    MusicManager.getInstance(context).play(sound)
}



@Composable
fun GetScreenWidth(): Int {
    val configuration = LocalConfiguration.current
    return configuration.screenWidthDp
}


@ExperimentalFoundationApi
@Preview
@Composable
fun PreviewAnimalGrid() {
    AnimalGrid(animals = AnimalData.AnimalSample, viewModel<WildAnimalViewModel>())
}