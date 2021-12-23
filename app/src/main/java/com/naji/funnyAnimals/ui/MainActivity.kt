package com.naji.funnyAnimals.ui

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.naji.funnyAnimals.ui.screen.DomesticScreen
import com.naji.funnyAnimals.ui.screen.HomeScreen
import com.naji.funnyAnimals.ui.screen.WildAnimalViewModel
import com.naji.funnyAnimals.ui.screen.WildScreen
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
//                Conversation(messages = SampleData.conversationSample)
            }

        }


    }

    @Composable
    fun NavigationComponent(navController: NavHostController){
        NavHost(navController = navController,
            startDestination = "Home" ){
            composable("Home"){
                HomeScreen(navController = navController)
            }

            composable("DomesticAnimal"){
                DomesticScreen()
            }

            composable("WildAnimal"){
                val viewModel = viewModel<WildAnimalViewModel>()
                WildScreen(viewModel)
            }
        }
    }



    private fun makeToast(mContext: Context, msg: String, length: Int) {
        Toast.makeText(mContext, msg, length).show()
    }
















}