package com.naji.funnyAnimals.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.LifecycleOwner
import com.naji.funnyAnimals.R
import com.naji.funnyAnimals.data.TYPE
import com.naji.funnyAnimals.ui.util.HandleResourceOnLifeCycle

@Composable
fun AquaticScreen(viewModel: WildAnimalViewModel,
                  lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current) {

    val context = LocalContext.current
    HandleResourceOnLifeCycle(lifecycleOwner, {}, {stopSound(context)})

    viewModel.init(TYPE.Aquatic)

    val animalList by viewModel.getAnimalList().observeAsState()
    Surface {
        Image(
            painter = painterResource(id = R.drawable.back_aquatic),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        animalList?.let { AnimalGrid(animals = it, viewModel, TYPE.Aquatic) }
    }
}