package com.naji.funnyAnimals.data

import androidx.compose.ui.graphics.Color
import com.naji.funnyAnimals.R
import com.naji.funnyAnimals.ui.theme.*

data class CardHome(
    val title: String, val description: String, val icon: Int,
    val background: Color,
    val backgroundIcon: Color,
    val titleColor: Color,
    val route: String
)

object HomeCardData {
    val HomeCardList = listOf(
        CardHome(
            "حیوانات", "آشنایی با حیوانات",
            R.drawable.animal_sheep, Green50, Green100, Green500,"DomesticAnimal"
        ),
        CardHome(
            "پرندگان", "آشنایی با پرندگان",
            R.drawable.bird_parrot, Orange50, Orange100,Orange500, "WildAnimal"
        ),
        CardHome(
            "حشرات", "آشنایی با حشرات",
            R.drawable.animal_leopard, Orange50, Orange100,Orange500, "WildAnimal"
        ),
        CardHome(
            "دریایی", "آشنایی با آبزیان",
            R.drawable.animal_fish, Cyan50, Cyan100,Cyan500, "WildAnimal"
        )
    )

}