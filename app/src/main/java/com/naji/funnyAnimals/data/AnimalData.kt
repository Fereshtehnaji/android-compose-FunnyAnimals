package com.naji.funnyAnimals.data

import androidx.compose.runtime.mutableStateListOf
import com.naji.funnyAnimals.R

object AnimalData {

    val AnimalData = listOf(
        Animal(R.drawable.animal_sheep, "گوسفند",R.raw.animal_sheep_fa,R.drawable.label_animal_fox, false),
        Animal(R.drawable.animal_cow, "گاو",R.raw.animal_cow_fa,R.drawable.label_animal_cow, false),
        Animal(R.drawable.animal_cat, "گربه",R.raw.animal_cat_fa,  R.drawable.label_animal_fox,false),
        Animal(R.drawable.animal_mouse, "موش",R.raw.animal_cat_fa,R.drawable.label_animal_fox, false),
        Animal(R.drawable.animal_rabbit, "خرگوش",R.raw.animal_cat_fa, R.drawable.label_animal_fox,false),
        Animal(R.drawable.animal_dog, "سگ",R.raw.animal_cat_fa, R.drawable.label_animal_fox,false),
        Animal(R.drawable.animal_elephant, "فیل", R.raw.animal_elephant_fa,R.drawable.label_animal_fox,false),
        Animal(R.drawable.animal_white_sheep, "گوسفند سفید",R.raw.animal_sheep_fa,R.drawable.label_animal_fox, false),
        Animal(R.drawable.animal_alligator, "تمساح",R.raw.animal_cat_fa, R.drawable.label_animal_fox,false),
        Animal(R.drawable.animal_bat, "خفاش",R.raw.animal_cat_fa,  R.drawable.label_animal_fox,false),
        Animal(R.drawable.animal_bear, "خرس",R.raw.animal_cat_fa,  R.drawable.label_animal_fox,false),
        Animal(R.drawable.animal_coala, "کوآلا", R.raw.animal_cat_fa,R.drawable.label_animal_fox,false),
        Animal(R.drawable.animal_cat2, "گربه قهوه ای", R.raw.animal_cat_fa,R.drawable.label_animal_fox,false),
        Animal(R.drawable.animal_giraffe, "زرافه", R.raw.animal_cat_fa,R.drawable.label_animal_fox,false),
        Animal(R.drawable.animal_fox, "روباه", R.raw.animal_fox_fa,R.drawable.label_animal_fox,false),
        Animal(R.drawable.animal_fish, "ماهی", R.raw.animal_cat_fa,R.drawable.label_animal_fox,false),
        Animal(R.drawable.animal_lion, "شیر",R.raw.animal_cat_fa, R.drawable.label_animal_fox,false),
        Animal(R.drawable.animal_leopard, "پلنگ",R.raw.animal_cat_fa,R.drawable.label_animal_fox, false),
        Animal(R.drawable.animal_rhino, "کرگدن", R.raw.animal_cat_fa,R.drawable.label_animal_fox,false),
        Animal(R.drawable.animal_blue_unicorn, "یونیکرن",R.raw.animal_cat_fa,  R.drawable.label_animal_fox,false),
        Animal(R.drawable.animal_lizard, "مارمولک", R.raw.animal_cat_fa,R.drawable.label_animal_fox,false),
        Animal(R.drawable.animal_panda, "پاندا", R.raw.animal_panda_fa,R.drawable.label_animal_fox,false),
        Animal(R.drawable.animal_tiger, "ببر",R.raw.animal_tiger_fa, R.drawable.label_animal_tiger,false),
        Animal(R.drawable.animal_zebra, "گورخر",R.raw.animal_cat_fa,R.drawable.label_animal_fox, false),
        Animal(R.drawable.animal_kangaroo, "کانگورو",R.raw.animal_cat_fa,R.drawable.label_animal_fox, false),
        Animal(R.drawable.animal_pink_unicorn, "یونیکرن",R.raw.animal_cat_fa,R.drawable.label_animal_fox, false),

        )

    val BugData = listOf(
        Animal(R.drawable.bug_antt, "مورچه",R.raw.animal_sheep_fa, R.drawable.label_animal_fox,false),
        Animal(R.drawable.bug_bee, "زنبور",R.raw.animal_sheep_fa,R.drawable.label_animal_fox, false),
        Animal(R.drawable.bug_centiped, "هزارپا",R.raw.animal_cat_fa,R.drawable.label_animal_fox, false),
        Animal(R.drawable.bug_cockroach, "سوسک سیاه",R.raw.animal_cat_fa,R.drawable.label_animal_fox, false),
        Animal(R.drawable.bug_cricket, "جیرجیرک",R.raw.animal_cat_fa, R.drawable.label_animal_fox,false),
        Animal(R.drawable.bug_dragonfly, "سنجاقک",R.raw.animal_cat_fa,R.drawable.label_animal_fox, false),
        Animal(R.drawable.bug_fly, "مگس",R.raw.animal_cat_fa, R.drawable.label_animal_fox,false),
        Animal(R.drawable.bug_locust, "ملخ", R.raw.animal_cat_fa,R.drawable.label_animal_fox,false),
        Animal(R.drawable.bug_silkworm, "کرم ابریشم", R.raw.animal_cat_fa,R.drawable.label_animal_fox,false),
        Animal(R.drawable.bug_snail, "حلزون", R.raw.animal_cat_fa,R.drawable.label_animal_fox,false),
        Animal(R.drawable.bug_spider, "عنکبوت", R.raw.animal_fox_fa,R.drawable.label_animal_fox,false),


        )


    val BirdData = listOf(
        Animal(R.drawable.bird_parrot, "طوطی",R.raw.animal_sheep_fa,R.drawable.label_animal_fox, false),
        Animal(R.drawable.bird_goose, "غاز",R.raw.animal_sheep_fa, R.drawable.label_animal_fox,false),
        Animal(R.drawable.bird_owl, "جغد",R.raw.bird_owl_en, R.drawable.label_animal_fox,false),
        Animal(R.drawable.bird_pelikan, "پلیکان",R.raw.animal_cat_fa, R.drawable.label_animal_fox,false),
        Animal(R.drawable.animal_rooster, "خروس", R.raw.animal_cat_fa,R.drawable.label_animal_fox,false),

        )

    val AquaticData = listOf(
        Animal(R.drawable.aquatic_fish, "ماهی",R.raw.animal_sheep_fa,R.drawable.label_animal_fox, false),
        Animal(R.drawable.aquatic_frog, "قورباغه",R.raw.animal_sheep_fa, R.drawable.label_aquatic_frog,false),
        Animal(R.drawable.aquatic_dolphin, "دلفین",R.raw.animal_sheep_fa, R.drawable.label_animal_fox,false),
        Animal(R.drawable.aquatic_jellyfish, "ستاره دریایی",R.raw.animal_sheep_fa, R.drawable.label_animal_fox,false),
        Animal(R.drawable.aquatic_walrus, "گراز دریایی",R.raw.animal_sheep_fa, R.drawable.label_animal_fox,false),

        )
}

data class Animal(val picture: Int, val name: String, val sound: Int, val label:Int, var isClicked: Boolean)
