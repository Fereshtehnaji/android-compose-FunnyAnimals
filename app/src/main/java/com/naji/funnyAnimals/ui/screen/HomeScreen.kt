package com.naji.funnyAnimals.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController){
    Column(modifier = Modifier.padding(30.dp)) {

        Button(onClick = {
            navController.navigate("DomesticAnimal") }) {
            Text(text = "حیوانات اهلی")
        }

        Button(onClick = { navController.navigate("WildAnimal") }) {
            Text(text = "حیوانات وحشی")
        }
    }
}