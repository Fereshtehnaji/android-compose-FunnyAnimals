package com.naji.funnyAnimals.data

import androidx.compose.runtime.mutableStateListOf
import com.naji.funnyAnimals.R

object AnimalData {

    val AnimalData = mutableStateListOf(
        Animal(R.drawable.animal_sheep, "گوسفند",R.raw.animal_sheep_fa, false),
        Animal(R.drawable.animal_white_sheep, "گوسفند سفید",R.raw.animal_sheep_fa, false),
        Animal(R.drawable.animal_alligator, "تمساح",R.raw.animal_cat_fa, false),
        Animal(R.drawable.animal_bat, "خفاش",R.raw.animal_cat_fa, false),
        Animal(R.drawable.animal_bear, "خرس",R.raw.animal_cat_fa, false),
        Animal(R.drawable.animal_blue_unicorn, "یونیکرن",R.raw.animal_cat_fa, false),
        Animal(R.drawable.animal_cat, "گربه",R.raw.animal_cat_fa, false),
        Animal(R.drawable.animal_coala, "کوآلا", R.raw.animal_cat_fa,false),
        Animal(R.drawable.animal_cat2, "گربه قهوه ای", R.raw.animal_cat_fa,false),
        Animal(R.drawable.animal_giraffe, "زرافه", R.raw.animal_cat_fa,false),
        Animal(R.drawable.animal_fox, "روباه", R.raw.animal_fox_fa,false),
        Animal(R.drawable.animal_fish, "ماهی", R.raw.animal_cat_fa,false),
        Animal(R.drawable.animal_lion, "شیر",R.raw.animal_cat_fa, false),
        Animal(R.drawable.animal_leopard, "پلنگ",R.raw.animal_cat_fa, false),
        Animal(R.drawable.animal_rhino, "کرگدن", R.raw.animal_cat_fa,false),
        Animal(R.drawable.animal_rabbit, "خرگوش",R.raw.animal_cat_fa, false),
        Animal(R.drawable.animal_rooster, "خروس", R.raw.animal_cat_fa,false),
        Animal(R.drawable.animal_dog, "سگ",R.raw.animal_cat_fa, false),
        Animal(R.drawable.animal_elepahnt, "فیل", R.raw.animal_elephant_fa,false),
        Animal(R.drawable.animal_lizard, "مارمولک", R.raw.animal_cat_fa,false),
        Animal(R.drawable.animal_mouse, "موش",R.raw.animal_cat_fa, false),
        Animal(R.drawable.animal_owl, "جغد",R.raw.animal_cat_fa, false),
        Animal(R.drawable.animal_panda, "پاندا", R.raw.animal_cat_fa,false),
        Animal(R.drawable.animal_pink_unicorn, "یونیکرن",R.raw.animal_cat_fa, false),
        Animal(R.drawable.animal_tiger, "ببر",R.raw.animal_cat_fa, false),
        Animal(R.drawable.animal_zebra, "گورخر",R.raw.animal_cat_fa, false),

        )

    val BugData = mutableStateListOf(
        Animal(R.drawable.bug_antt, "مورچه",R.raw.animal_sheep_fa, false),
        Animal(R.drawable.bug_be, "زنبور",R.raw.animal_sheep_fa, false),
        Animal(R.drawable.bug_centiped, "هزارپا",R.raw.animal_cat_fa, false),
        Animal(R.drawable.bug_cockroach, "سوسک سیاه",R.raw.animal_cat_fa, false),
        Animal(R.drawable.bug_cricket, "جیرجیرک",R.raw.animal_cat_fa, false),
        Animal(R.drawable.bug_dragonfly, "سنجاقک",R.raw.animal_cat_fa, false),
        Animal(R.drawable.bug_fly, "مگس",R.raw.animal_cat_fa, false),
        Animal(R.drawable.bug_locust, "ملخ", R.raw.animal_cat_fa,false),
        Animal(R.drawable.bug_silkworm, "کرم ابریشم", R.raw.animal_cat_fa,false),
        Animal(R.drawable.bug_snail, "حلزون", R.raw.animal_cat_fa,false),
        Animal(R.drawable.bug_spider, "عنکبوت", R.raw.animal_fox_fa,false),


        )


    val BirdData = mutableStateListOf(
        Animal(R.drawable.bird_parrot, "طوطی",R.raw.animal_sheep_fa, false),
        Animal(R.drawable.bird_goose, "غاز",R.raw.animal_sheep_fa, false),

        )

    val AquaticData = mutableStateListOf(
        Animal(R.drawable.bird_parrot, "طوطی",R.raw.animal_sheep_fa, false),
        Animal(R.drawable.bird_goose, "غاز",R.raw.animal_sheep_fa, false),

        )
}

data class Animal(val picture: Int, val name: String, val sound: Int, var animate: Boolean)
