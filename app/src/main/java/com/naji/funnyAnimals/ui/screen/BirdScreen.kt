package com.naji.funnyAnimals.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.LifecycleOwner
import com.naji.funnyAnimals.data.Animal
import com.naji.funnyAnimals.data.TYPE
import com.naji.funnyAnimals.ui.util.HandleResourceOnLifeCycle


@Composable
fun BirdScreen(viewModel: ViewModel,
               lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current){

    val context = LocalContext.current
    HandleResourceOnLifeCycle(lifecycleOwner, {}, {stopSound(context)})

    viewModel.init(TYPE.BIRD)

    val items: List<Animal> by viewModel.animalItems.observeAsState(listOf())

    AnimalGrid(animals = items, onClickHandler = { viewModel.clickHandler(it) })

}
