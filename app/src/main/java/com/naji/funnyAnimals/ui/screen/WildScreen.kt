package com.naji.funnyAnimals.ui.screen

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.naji.funnyAnimals.data.Animal
import com.naji.funnyAnimals.data.AnimalData


var selectedIndex = -1

@Composable
fun WildScreen(viewModel: WildAnimalViewModel) {

    AnimalGrid(animals = AnimalData.AnimalSample)
}

@Composable
fun AnimalGrid(animals: List<Animal>) {

    val numberOfItemsByRow = GetScreenWidth() / 120

    LazyColumn(modifier = Modifier.padding(all = 8.dp)) {


        items(items = animals.chunked(numberOfItemsByRow)) { rowItems ->
            Row(
                horizontalArrangement = Arrangement.spacedBy(14.dp),
                modifier = Modifier.padding(horizontal = 16.dp),
            ) {
                for (animal in rowItems) {
                    animal.animate = rowItems.indexOf(animal) == selectedIndex
                    AnimalItem(animal = animal, rowItems.indexOf(animal), true)

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




data class AnimationValue(var index: Int, var state: Boolean)

@Composable
fun AnimalItem(animal: Animal, index: Int, animationState: Boolean) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(all = 8.dp)
    ) {

        var animationValue = AnimationValue(4, false)
        var isClicked by remember { mutableStateOf(false) }
        var animData by remember {
            mutableStateOf(animationValue)
        }

        val infiniteTransition = rememberInfiniteTransition()
        val angle by infiniteTransition.animateFloat(
            initialValue = 0F,
            targetValue = if (isClicked and animal.animate) 360F else 0F,
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
                    selectedIndex = index
                    animal.animate = true
                    animData.index = 4
                    animData.state = true
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


@Composable
fun GetScreenWidth(): Int {
    val configuration = LocalConfiguration.current
    return configuration.screenWidthDp
}


@ExperimentalFoundationApi
@Preview
@Composable
fun PreviewAnimalGrid() {
    AnimalGrid(animals = AnimalData.AnimalSample)
}