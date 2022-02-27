package com.naji.funnyAnimals.ui.screen

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.dimensionResource
import com.naji.funnyAnimals.R
import com.naji.funnyAnimals.data.Animal
import com.naji.funnyAnimals.data.animalenum.TYPE


@Composable
fun AnimalGrid(animals: List<Animal>, onClickHandler: (Animal) -> Unit, type: TYPE) {

    val configuration = LocalConfiguration.current

    val numberOfItemsByRow = remember { getScreenWidth(configuration) / SCREEN_CONST }

    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {


        items(items = animals.chunked(numberOfItemsByRow)) { rowItems ->

            Spacer(Modifier.height(dimensionResource(id = R.dimen._18sdp)))

            Row(
                horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen._18sdp)),

                ) {

                for (animal in rowItems) {
                    AnimalItem(animal = animal, onClickHandler, type)
                }
            }
        }

    }
}

fun getScreenWidth(configuration: Configuration): Int {
    return configuration.screenWidthDp
}




