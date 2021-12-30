package com.naji.funnyAnimals.ui.screen

import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.naji.funnyAnimals.R
import com.naji.funnyAnimals.data.AnimalData
import com.naji.funnyAnimals.data.TYPE


const val SCREEN_CONST = 120


@Composable
fun AnimalScreen(viewModel: WildAnimalViewModel) {
    val context = LocalContext.current

    viewModel.init(TYPE.ANIMAL)

    val animalList by viewModel.getAnimalList().observeAsState()

    Surface() {
        Image(
            painter = painterResource(id = R.drawable.back_icon),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        animalList?.let { AnimalGrid(animals = it, viewModel, TYPE.ANIMAL) }
    }
    BackHandler(enabled = true) {
        Toast.makeText(context, "haaaaaahaaaaaaaa", Toast.LENGTH_LONG).show()
        // execute your custom logic here
    }
}


@ExperimentalFoundationApi
@Preview
@Composable
fun PreviewAnimalGrid() {
    AnimalGrid(animals = AnimalData.AnimalData, viewModel<WildAnimalViewModel>(), TYPE.ANIMAL)

}

@Composable
public fun BackHandler(enabled: Boolean = true, onBack: () -> Unit) {

}