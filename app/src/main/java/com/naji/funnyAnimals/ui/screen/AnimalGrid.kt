package com.naji.funnyAnimals.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.naji.funnyAnimals.data.Animal
import com.naji.funnyAnimals.data.TYPE

@Composable
fun AnimalGrid(animals: List<Animal>, viewModel: WildAnimalViewModel, type: TYPE) {

    val numberOfItemsByRow = GetScreenWidth() / SCREEN_CONST

    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        items(items = animals.chunked(numberOfItemsByRow)) { rowItems ->
            Row(
                horizontalArrangement = Arrangement.spacedBy(14.dp),
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {

                for (animal in rowItems) {
                    AnimalItem(animal = animal, viewModel, type)
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