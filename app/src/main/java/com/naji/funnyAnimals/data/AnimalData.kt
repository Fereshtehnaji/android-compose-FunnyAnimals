package com.naji.funnyAnimals.data

import androidx.compose.runtime.mutableStateListOf
import com.naji.funnyAnimals.R

object AnimalData {

    val AnimalSample = mutableStateListOf(
        Animal(R.drawable.animal_sheep, "گوسفند", false),
        Animal(R.drawable.animal_white_sheep, "گوسفند سفید", false),
        Animal(R.drawable.animal_alligator, "تمساح", false),
        Animal(R.drawable.animal_bat, "خفاش", false),
        Animal(R.drawable.animal_bear, "خرس", false),
        Animal(R.drawable.animal_blue_unicorn, "یونیکرن", false),
        Animal(R.drawable.animal_cat, "گربه", false),
        Animal(R.drawable.animal_coala, "کوآلا", false),
        Animal(R.drawable.animal_cat2, "گربه قهوه ای", false),
        Animal(R.drawable.animal_giraffe, "زرافه", false),
        Animal(R.drawable.animal_fox, "روباره", false),
        Animal(R.drawable.animal_fish, "ماهی", false),
        Animal(R.drawable.animal_lion, "شیر", false),
        Animal(R.drawable.animal_leopard, "پلنگ", false),
        Animal(R.drawable.animal_rhino, "کرگدن", false),
        Animal(R.drawable.animal_rabbit, "خرگوش", false),
        Animal(R.drawable.animal_rooster, "خروس", false),
        Animal(R.drawable.animal_dog, "سگ", false),
        Animal(R.drawable.animal_elepahnt, "فیل", false),
        Animal(R.drawable.animal_lizard, "مارمولک", false),
        Animal(R.drawable.animal_mouse, "موش", false),
        Animal(R.drawable.animal_owl, "جغد", false),
        Animal(R.drawable.animal_panda, "پاندا", false),
        Animal(R.drawable.animal_pink_unicorn, "یونیکرن", false),
        Animal(R.drawable.animal_tiger, "ببر", false),
        Animal(R.drawable.animal_zebra, "گورخز", false),

        )
}

data class Animal(val picture: Int, val name: String, var animate: Boolean)
