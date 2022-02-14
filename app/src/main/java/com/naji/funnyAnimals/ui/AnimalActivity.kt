package com.naji.funnyAnimals.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.naji.funnyAnimals.R
import com.naji.funnyAnimals.data.animalenum.HomeGroup
import com.naji.funnyAnimals.data.animalenum.TYPE
import com.naji.funnyAnimals.ui.screen.HomeScreen
import com.naji.funnyAnimals.ui.screen.NavigateScreen
import com.naji.funnyAnimals.ui.theme.AnimalAppTheme
import com.naji.funnyAnimals.ui.util.MusicService

@ExperimentalComposeUiApi
@ExperimentalFoundationApi
class AnimalActivity : AppCompatActivity() {


    private val viewModel: AnimalViewModel by viewModels {
        AnimalViewModelFactory((application as AnimalApplication).repository)
    }

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

                HomeScreen(navController, viewModel)

            }

            composable(HomeGroup.BIRD.nameType) {

                val title = stringResource(id = R.string.birds_title)
                val backgroundImageId = R.drawable.back_birds4

                NavigateScreen(
                    viewModel,
                    LocalLifecycleOwner.current,
                    { navController.navigateUp() }, title, backgroundImageId, TYPE.BIRD
                )
            }

            composable(HomeGroup.ANIMAL.nameType) {

                val title = stringResource(id = R.string.animal_title)

                val backgroundImageId = R.drawable.back_icon

                NavigateScreen(
                    viewModel,
                    LocalLifecycleOwner.current,
                    { navController.navigateUp() }, title, backgroundImageId, TYPE.ANIMAL
                )
            }

            composable(HomeGroup.BUG.nameType) {

                val title = stringResource(id = R.string.bugs_title)
//                val backgroundImageId = R.drawable.back_birds3

                NavigateScreen(
                    viewModel,
                    LocalLifecycleOwner.current,
                    { navController.navigateUp() },
                    title,
                    null,
                    TYPE.BUG
                )
            }

            composable(HomeGroup.AQUATIC.nameType) {

                val title = stringResource(id = R.string.ocean_title)
                val backgroundImageId = R.drawable.back_aquatic

                NavigateScreen(
                    viewModel,
                    LocalLifecycleOwner.current,
                    { navController.navigateUp() }, title, backgroundImageId, TYPE.AQUATIC
                )
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        val intent = Intent(this, MusicService::class.java)
        stopService(intent)
    }
}
