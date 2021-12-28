package com.naji.funnyAnimals.ui.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.naji.funnyAnimals.data.AnimalData
import com.naji.funnyAnimals.data.TYPE


const val SCREEN_CONST = 120


@Composable
fun AnimalScreen(viewModel: WildAnimalViewModel) {

    viewModel.init(TYPE.ANIMAL)

    val animalList by viewModel.getAnimalList().observeAsState()

    animalList?.let { AnimalGrid(animals = it, viewModel,TYPE.ANIMAL) }
}


@ExperimentalFoundationApi
@Preview
@Composable
fun PreviewAnimalGrid() {
    AnimalGrid(animals = AnimalData.AnimalData, viewModel<WildAnimalViewModel>(),TYPE.ANIMAL)
}