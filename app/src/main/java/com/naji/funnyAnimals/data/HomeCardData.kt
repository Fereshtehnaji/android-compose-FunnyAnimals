package com.naji.funnyAnimals.data

import com.naji.funnyAnimals.R
import com.naji.funnyAnimals.ui.theme.*
import androidx.compose.ui.graphics.Color

data class CardHome(
    val title: String, val description: String, val icon: Int,
    val background: Color,
    val route : String
)

object HomeCardData{
    val HomeCardList = listOf(
        CardHome("حیوانات اهلی","صدای حیوانات اهلی", R.drawable.animal_sheep, Teal200,"DomesticAnimal"),
        CardHome("حیوانات وحشی","",R.drawable.animal_bear, Teal100,"WildAnimal"),
        CardHome("حشرات","آشنایی با دنیای حشرات",R.drawable.animal_leopard, Teal50,"WildAnimal"),
        CardHome("حیوانات دریایی","آشنایی یا آبزیان",R.drawable.animal_fish, LightBlue100,"WildAnimal")
    )

}