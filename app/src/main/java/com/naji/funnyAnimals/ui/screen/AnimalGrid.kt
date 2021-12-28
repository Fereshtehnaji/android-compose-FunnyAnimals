package com.naji.funnyAnimals.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.naji.funnyAnimals.data.Animal

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