package com.naji.funnyAnimals.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import com.naji.funnyAnimals.data.TYPE

@Composable
fun BugScreen(viewModel: WildAnimalViewModel) {

    viewModel.init(TYPE.BUG)

    val animalList by viewModel.getAnimalList().observeAsState()

    animalList?.let { AnimalGrid(animals = it, viewModel,TYPE.BUG) }
}