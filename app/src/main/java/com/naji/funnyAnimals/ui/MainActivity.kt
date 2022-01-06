package com.naji.funnyAnimals.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.naji.funnyAnimals.data.Animal
import com.naji.funnyAnimals.data.HomeGroup
import com.naji.funnyAnimals.data.TYPE
import com.naji.funnyAnimals.ui.screen.*
import com.naji.funnyAnimals.ui.theme.AnimalAppTheme


@ExperimentalFoundationApi
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val navController = rememberNavController()
            AnimalAppTheme {
                Scaffold {
                    NavigationComponent(navController)
                }
            }

        }


    }

    @Composable
    fun NavigationComponent(navController: NavHostController) {
        NavHost(
            navController = navController,
            startDestination = HomeGroup.HOME.nameType
        ) {
            composable(HomeGroup.HOME.nameType) {
                HomeScreen(navController = navController)
            }

            composable(HomeGroup.BIRD.nameType) {
                val viewModel = viewModel<WildAnimalViewModel>()
                BirdScreen(viewModel, LocalLifecycleOwner.current)
            }

            composable(HomeGroup.ANIMAL.nameType) {
                val viewModel = viewModel<WildAnimalViewModel>()
                AnimalScreen(viewModel, LocalLifecycleOwner.current)
            }

            composable(HomeGroup.BUG.nameType) {
                val viewModel = viewModel<WildAnimalViewModel>()
                BugScreen(viewModel, LocalLifecycleOwner.current)
            }

            composable(HomeGroup.AQUATIC.nameType) {
                val viewModel = viewModel<WildAnimalViewModel>()
                AquaticScreen(viewModel, LocalLifecycleOwner.current)
            }
        }
    }

}
