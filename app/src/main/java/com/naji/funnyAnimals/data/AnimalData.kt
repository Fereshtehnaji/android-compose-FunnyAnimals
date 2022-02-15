package com.naji.funnyAnimals.data

import com.naji.funnyAnimals.R
import com.naji.funnyAnimals.data.animalenum.Language
import com.naji.funnyAnimals.data.animalenum.TYPE


object AnimalData {

    val AnimalData = listOf(
        Animal(
            "sheep", "گوسفند", Language.EN.nameType, R.drawable.animal_white_sheep,
            R.raw.animal_sheep_fa, R.drawable.label_animal_sheep, TYPE.ANIMAL.nameType, false
        ),
        Animal("cow", "گاو", Language.FA.nameType, R.drawable.animal_cow, R.raw.animal_cow_fa,
            R.drawable.label_animal_cow, TYPE.ANIMAL.nameType, false
        ),
        Animal("cat", "گربه", Language.FA.nameType, R.drawable.animal_cat2,
            R.raw.animal_cat_fa, R.drawable.label_animal_cat, TYPE.ANIMAL.nameType, false
        ),
        Animal("chicken", "مرغ", Language.FA.nameType, R.drawable.animal_chicken,
            R.raw.animal_chiken_fa, R.drawable.label_animal_chicken, TYPE.ANIMAL.nameType, false
        ),
        Animal("mouse", "موش", Language.FA.nameType, R.drawable.animal_mouse, R.raw.animal_mouse_fa,
            R.drawable.label_animal_mouse, TYPE.ANIMAL.nameType, false
        ),
        Animal("rabbit", "خرگوش", Language.FA.nameType, R.drawable.animal_rabbit,
            R.raw.animal_cat_fa, R.drawable.label_animal_rabbit, TYPE.ANIMAL.nameType, false
        ),
        Animal("dog", "سگ", Language.FA.nameType, R.drawable.animal_dog,
            R.raw.animal_dog_fa, R.drawable.label_animal_dog, TYPE.ANIMAL.nameType, false
        ),
        Animal("elephant", "فیل", Language.FA.nameType, R.drawable.animal_elephant,
            R.raw.animal_elephant_fa, R.drawable.label_animal_elephant, TYPE.ANIMAL.nameType, false
        ),
        Animal("alligator", "تمساح", Language.FA.nameType, R.drawable.animal_alligator,
            R.raw.animal_cat_fa, R.drawable.label_animal_fox, TYPE.ANIMAL.nameType, false
        ),
        Animal("bat", "خفاش", Language.FA.nameType, R.drawable.animal_bat,
            R.raw.animal_cat_fa, R.drawable.label_animal_fox, TYPE.ANIMAL.nameType, false
        ),
        Animal("bear", "خرس", Language.FA.nameType, R.drawable.animal_bear,
            R.raw.animal_cat_fa, R.drawable.label_animal_fox, TYPE.ANIMAL.nameType, false
        ),
        Animal("coala", "کوآلا", Language.FA.nameType, R.drawable.animal_coala,
            R.raw.animal_cat_fa, R.drawable.label_animal_fox, TYPE.ANIMAL.nameType, false
        ),
        Animal("giraffe", "زرافه", Language.FA.nameType, R.drawable.animal_giraffe,
            R.raw.animal_cat_fa, R.drawable.label_animal_fox, TYPE.ANIMAL.nameType, false
        ),
        Animal("fox", "روباه", Language.FA.nameType, R.drawable.animal_fox,
            R.raw.animal_fox_fa, R.drawable.label_animal_fox, TYPE.ANIMAL.nameType, false
        ),
        Animal("lion", "شیر", Language.FA.nameType, R.drawable.animal_lion,
            R.raw.animal_lion_en, R.drawable.label_animal_lion, TYPE.ANIMAL.nameType, false
        ),
        Animal("leopard", "پلنگ", Language.FA.nameType, R.drawable.animal_leopard,
            R.raw.animal_cat_fa, R.drawable.label_animal_fox, TYPE.ANIMAL.nameType, false
        ),
        Animal("rhino", "کرگدن", Language.FA.nameType, R.drawable.animal_rhino,
            R.raw.animal_rhino_fa, R.drawable.label_animal_fox, TYPE.ANIMAL.nameType, false
        ),
        Animal("panda", "پاندا", Language.FA.nameType, R.drawable.animal_panda,
            R.raw.animal_panda_fa, R.drawable.label_animal_fox, TYPE.ANIMAL.nameType, false
        ),
        Animal("tiger", "ببر", Language.FA.nameType, R.drawable.animal_tiger,
            R.raw.animal_tiger_fa, R.drawable.label_animal_tiger, TYPE.ANIMAL.nameType, false
        ),
        Animal("zebra", "گورخر", Language.FA.nameType, R.drawable.animal_zebra,
            R.raw.animal_zebra_fa, R.drawable.label_animal_fox, TYPE.ANIMAL.nameType, false
        ),
        Animal("kangaroo", "کانگورو", Language.FA.nameType, R.drawable.animal_kangaroo,
            R.raw.animal_cat_fa, R.drawable.label_animal_fox, TYPE.ANIMAL.nameType, false
        ),
        Animal("chameleons", "آفتاب پرست", Language.FA.nameType, R.drawable.animal_chameleons,
            R.raw.animal_cat_fa, R.drawable.label_animal_fox, TYPE.ANIMAL.nameType, false
        ),
        Animal("monkey", "میمون", Language.FA.nameType, R.drawable.animal_monkey,
            R.raw.animal_monkey_fa, R.drawable.label_animal_fox, TYPE.ANIMAL.nameType, false
        ),
        Animal("raccoon", "راکون", Language.FA.nameType, R.drawable.animal_raccoon,
            R.raw.animal_monkey_fa, R.drawable.label_animal_fox, TYPE.ANIMAL.nameType, false),




        Animal("parrot", "طوطی", Language.FA.nameType, R.drawable.bird_parrot,
            R.raw.animal_sheep_fa, R.drawable.label_animal_fox, TYPE.BIRD.nameType, false
        ),
        Animal("goose", "غاز", Language.FA.nameType, R.drawable.bird_goose,
            R.raw.animal_sheep_fa, R.drawable.label_animal_fox, TYPE.BIRD.nameType, false
        ),
        Animal("owl", "جغد", Language.FA.nameType, R.drawable.bird_owl,
            R.raw.bird_owl_en, R.drawable.label_animal_fox, TYPE.BIRD.nameType, false
        ),
        Animal("pelikan", "پلیکان", Language.FA.nameType, R.drawable.bird_pelikan,
            R.raw.animal_cat_fa, R.drawable.label_animal_fox, TYPE.BIRD.nameType, false
        ),
        Animal("rooster", "خروس", Language.FA.nameType, R.drawable.animal_rooster,
            R.raw.animal_cat_fa, R.drawable.label_animal_fox, TYPE.BIRD.nameType,
            false
        ),


        Animal("ant", "مورچه", Language.FA.nameType, R.drawable.bug_antt,
            R.raw.animal_monkey_fa, R.drawable.label_bug_ant, TYPE.BUG.nameType, false
        ),
        Animal("bee", "زنبور", Language.FA.nameType, R.drawable.bug_bee,
            R.raw.insect_bee_fa, R.drawable.label_bug_bee, TYPE.BUG.nameType, false
        ),
        Animal("centipede", "هزارپا", Language.FA.nameType, R.drawable.bug_centiped,
            R.raw.animal_cat_fa, R.drawable.label_bug_centiped, TYPE.BUG.nameType, false
        ),
        Animal("cockroach", "سوسک", Language.FA.nameType, R.drawable.bug_cockroach,
            R.raw.animal_cat_fa, R.drawable.label_bug_cockroach, TYPE.BUG.nameType, false
        ),
        Animal("cricket", "جیرجیرک", Language.FA.nameType, R.drawable.bug_cricket,
            R.raw.animal_cat_fa, R.drawable.label_bug_cricket, TYPE.BUG.nameType, false
        ),
        Animal("dragonfly", "سنجاقک", Language.FA.nameType, R.drawable.bug_dragonfly,
            R.raw.animal_cat_fa, R.drawable.label_bug_dragonfly, TYPE.BUG.nameType, false
        ),
        Animal("fly", "مگس", Language.FA.nameType, R.drawable.bug_fly,
            R.raw.animal_cat_fa, R.drawable.label_bug_fly, TYPE.BUG.nameType, false
        ),
        Animal("locust", "ملخ", Language.FA.nameType, R.drawable.bug_locust,
            R.raw.animal_cat_fa, R.drawable.label_bug_locust, TYPE.BUG.nameType, false
        ),
        Animal("silkworm", "کرم ابریشم", Language.FA.nameType, R.drawable.bug_silkworm,
            R.raw.animal_cat_fa, R.drawable.label_bug_silkworm, TYPE.BUG.nameType, false
        ),
        Animal("snail", "حلزون", Language.FA.nameType, R.drawable.bug_snail,
            R.raw.animal_cat_fa, R.drawable.label_bug_snail, TYPE.BUG.nameType, false
        ),
        Animal("spider", "عنکبوت", Language.FA.nameType, R.drawable.bug_spider,
            R.raw.animal_fox_fa, R.drawable.label_bug_spider, TYPE.BUG.nameType, false
        ),

        )

    val BIRDDataEn = listOf(
        Animal("parrot", "طوطی", Language.EN.nameType, R.drawable.bird_parrot,
            R.raw.animal_sheep_fa, R.drawable.label_animal_fox, TYPE.BIRD.nameType, false
        ),
        Animal("goose", "غاز", Language.EN.nameType, R.drawable.bird_goose,
            R.raw.animal_sheep_fa, R.drawable.label_animal_fox, TYPE.BIRD.nameType, false
        ),
        Animal("owl", "جغد", Language.EN.nameType, R.drawable.bird_owl,
            R.raw.bird_owl_en, R.drawable.label_animal_fox, TYPE.BIRD.nameType, false
        ),
        Animal("pelikan", "پلیکان", Language.EN.nameType, R.drawable.bird_pelikan,
            R.raw.animal_cat_fa, R.drawable.label_animal_fox, TYPE.BIRD.nameType, false
        ),
        Animal("rooster", "خروس", Language.EN.nameType, R.drawable.animal_rooster,
            R.raw.animal_cat_fa, R.drawable.label_animal_fox, TYPE.BIRD.nameType, false
        ),

        )

    val AquaticData = listOf(
        Animal("fish", "ماهی", Language.FA.nameType, R.drawable.aquatic_fish,
            R.raw.animal_sheep_fa, R.drawable.label_animal_fox, TYPE.AQUATIC.nameType, false
        ),
        Animal("frog", "قورباغه", Language.FA.nameType, R.drawable.aquatic_frog,
            R.raw.animal_sheep_fa, R.drawable.label_aquatic_frog, TYPE.AQUATIC.nameType, false
        ),
        Animal("dolphin", "دلفین", Language.FA.nameType, R.drawable.aquatic_dolphin,
            R.raw.animal_sheep_fa, R.drawable.label_animal_fox, TYPE.AQUATIC.nameType, false
        ),
        Animal("jellyfish", "ستاره دریایی", Language.FA.nameType, R.drawable.aquatic_jellyfish,
            R.raw.animal_sheep_fa, R.drawable.label_animal_fox, TYPE.AQUATIC.nameType, false
        ),
        Animal("walrus", "گراز دریایی", Language.FA.nameType, R.drawable.aquatic_walrus,
            R.raw.animal_sheep_fa, R.drawable.label_animal_fox, TYPE.AQUATIC.nameType, false
        ),
        Animal("turtle", "لاک پشت", Language.FA.nameType, R.drawable.aquatic_turtle,
            R.raw.animal_turtle_en, R.drawable.label_animal_fox, TYPE.AQUATIC.nameType, false
        ),

        )

    val AquaticDataEn = listOf(
        Animal(
            "fish-en",
            "ماهی",
            Language.EN.nameType,
            R.drawable.aquatic_fish,
            R.raw.animal_sheep_fa,
            R.drawable.label_animal_fox,
            TYPE.AQUATIC.nameType,
            false
        ),
        Animal(
            "frog-en",
            "قورباغه",
            Language.EN.nameType,
            R.drawable.aquatic_frog,
            R.raw.animal_sheep_fa,
            R.drawable.label_aquatic_frog,
            TYPE.AQUATIC.nameType,
            false
        ),
        Animal(
            "dolphin-en",
            "دلفین",
            Language.EN.nameType,
            R.drawable.aquatic_dolphin,
            R.raw.animal_sheep_fa,
            R.drawable.label_animal_fox,
            TYPE.AQUATIC.nameType,
            false
        ),
        Animal(
            "jellyfish-en",
            "ستاره دریایی",
            Language.EN.nameType,
            R.drawable.aquatic_jellyfish,
            R.raw.animal_sheep_fa,
            R.drawable.label_animal_fox,
            TYPE.AQUATIC.nameType,
            false
        ),
        Animal(
            "walrus-en",
            "گراز دریایی",
            Language.EN.nameType,
            R.drawable.aquatic_walrus,
            R.raw.animal_sheep_fa,
            R.drawable.label_animal_fox,
            TYPE.AQUATIC.nameType,
            false
        ),
        Animal(
            "turtle-en",
            "لاک پشت",
            Language.EN.nameType,
            R.drawable.aquatic_turtle,
            R.raw.animal_turtle_en,
            R.drawable.label_animal_fox,
            TYPE.AQUATIC.nameType,
            false
        ),

        )


    val AnimalDataEn = listOf(
        Animal("sheep-en", "گوسفند", Language.EN.nameType, R.drawable.animal_white_sheep,
            R.raw.animal_sheep_en, R.drawable.label_animal_sheep, TYPE.ANIMAL.nameType, false
        ),
        Animal("cow-en", "گاو", Language.EN.nameType, R.drawable.animal_cow,
            R.raw.animal_cow_en, R.drawable.label_animal_cow, TYPE.ANIMAL.nameType, false
        ),
        Animal("cat-en", "گربه", Language.EN.nameType, R.drawable.animal_cat2,
            R.raw.animal_cat_en, R.drawable.label_animal_cat, TYPE.ANIMAL.nameType, false
        ),
        Animal("chicken-en", "مرغ", Language.EN.nameType, R.drawable.animal_chicken,
            R.raw.animal_chiken_fa, R.drawable.label_animal_chicken, TYPE.ANIMAL.nameType, false
        ),
        Animal(
            "mouse-en",
            "موش",
            Language.EN.nameType,
            R.drawable.animal_mouse,
            R.raw.animal_mouse_fa,
            R.drawable.label_animal_mouse,
            TYPE.ANIMAL.nameType,
            false
        ),
        Animal(
            "rabbit-en",
            "خرگوش",
            Language.EN.nameType,
            R.drawable.animal_rabbit,
            R.raw.animal_cat_fa,
            R.drawable.label_animal_rabbit,
            TYPE.ANIMAL.nameType,
            false
        ),
        Animal("dog-en", "سگ", Language.EN.nameType, R.drawable.animal_dog,
            R.raw.animal_dog_fa, R.drawable.label_animal_dog, TYPE.ANIMAL.nameType, false
        ),
        Animal("elephant-en", "فیل", Language.EN.nameType, R.drawable.animal_elephant,
            R.raw.animal_elephant_fa, R.drawable.label_animal_elephant, TYPE.ANIMAL.nameType, false
        ),
        Animal("alligator-en", "تمساح", Language.EN.nameType, R.drawable.animal_alligator,
            R.raw.animal_cat_fa, R.drawable.label_animal_fox, TYPE.ANIMAL.nameType, false
        ),
        Animal("bat-en", "خفاش", Language.EN.nameType, R.drawable.animal_bat,
            R.raw.animal_cat_fa, R.drawable.label_animal_fox, TYPE.ANIMAL.nameType, false
        ),
        Animal("bear-en", "خرس", Language.EN.nameType, R.drawable.animal_bear,
            R.raw.animal_cat_fa, R.drawable.label_animal_fox, TYPE.ANIMAL.nameType, false
        ),
        Animal("coala-en", "کوآلا", Language.EN.nameType, R.drawable.animal_coala,
            R.raw.animal_cat_fa, R.drawable.label_animal_fox, TYPE.ANIMAL.nameType, false
        ),
        Animal("giraffe-en", "زرافه", Language.EN.nameType, R.drawable.animal_giraffe,
            R.raw.animal_cat_fa, R.drawable.label_animal_fox, TYPE.ANIMAL.nameType, false
        ),
        Animal("fox-en", "روباه", Language.EN.nameType, R.drawable.animal_fox,
            R.raw.animal_fox_fa, R.drawable.label_animal_fox, TYPE.ANIMAL.nameType, false
        ),
        Animal("lion-en", "شیر", Language.EN.nameType, R.drawable.animal_lion,
            R.raw.animal_lion_en, R.drawable.label_animal_lion, TYPE.ANIMAL.nameType, false
        ),
        Animal("leopard-en", "پلنگ", Language.EN.nameType, R.drawable.animal_leopard,
            R.raw.animal_cat_fa, R.drawable.label_animal_fox, TYPE.ANIMAL.nameType, false
        ),
        Animal(
            "rhino-en",
            "کرگدن",
            Language.EN.nameType,
            R.drawable.animal_rhino,
            R.raw.animal_rhino_fa,
            R.drawable.label_animal_fox,
            TYPE.ANIMAL.nameType,
            false
        ),
        Animal(
            "panda-en",
            "پاندا",
            Language.EN.nameType,
            R.drawable.animal_panda,
            R.raw.animal_panda_fa,
            R.drawable.label_animal_fox,
            TYPE.ANIMAL.nameType,
            false
        ),
        Animal("tiger-en", "ببر", Language.EN.nameType, R.drawable.animal_tiger,
            R.raw.animal_tiger_fa, R.drawable.label_animal_tiger, TYPE.ANIMAL.nameType, false
        ),
        Animal("zebra-en", "گورخر", Language.EN.nameType, R.drawable.animal_zebra,
            R.raw.animal_zebra_fa, R.drawable.label_animal_fox, TYPE.ANIMAL.nameType, false
        ),
        Animal("kangaroo-en", "کانگورو", Language.EN.nameType, R.drawable.animal_kangaroo,
            R.raw.animal_cat_fa, R.drawable.label_animal_fox, TYPE.ANIMAL.nameType, false
        ),
        Animal("chameleons-en", "آفتاب پرست", Language.EN.nameType, R.drawable.animal_chameleons,
            R.raw.animal_cat_fa, R.drawable.label_animal_fox, TYPE.ANIMAL.nameType, false
        ),
        Animal("monkey-en", "میمون", Language.EN.nameType, R.drawable.animal_monkey,
            R.raw.animal_monkey_fa, R.drawable.label_animal_fox, TYPE.ANIMAL.nameType, false
        ),
        Animal("raccoon-en", "راکون", Language.EN.nameType, R.drawable.animal_raccoon,
            R.raw.animal_monkey_fa, R.drawable.label_animal_fox, TYPE.ANIMAL.nameType, false
        ),

        )


    val BugDataEn = listOf(
        Animal("antt-en", "مورچه", Language.EN.nameType, R.drawable.bug_antt,
            R.raw.animal_sheep_fa, R.drawable.label_bug_ant, TYPE.BUG.nameType, false
        ),
        Animal(
            "bee-en", "زنبور", Language.EN.nameType, R.drawable.bug_bee,
            R.raw.insect_bee_fa, R.drawable.label_bug_bee, TYPE.BUG.nameType, false
        ),
        Animal(
            "centiped-en", "هزارپا", Language.EN.nameType, R.drawable.bug_centiped,
            R.raw.animal_cat_fa, R.drawable.label_bug_centiped, TYPE.BUG.nameType, false
        ),
        Animal("cockroach-en", "سوسک", Language.EN.nameType, R.drawable.bug_cockroach,
            R.raw.animal_cat_fa, R.drawable.label_bug_cockroach, TYPE.BUG.nameType, false
        ),
        Animal("cricket-en", "جیرجیرک", Language.EN.nameType, R.drawable.bug_cricket,
            R.raw.animal_cat_fa, R.drawable.label_bug_cricket, TYPE.BUG.nameType, false
        ),
        Animal("dragonfly-en", "سنجاقک", Language.EN.nameType, R.drawable.bug_dragonfly,
            R.raw.animal_cat_fa, R.drawable.label_bug_dragonfly, TYPE.BUG.nameType, false
        ),
        Animal("fly-en", "مگس", Language.EN.nameType, R.drawable.bug_fly,
            R.raw.animal_cat_fa, R.drawable.label_bug_fly, TYPE.BUG.nameType, false
        ),
        Animal("locust-en", "ملخ", Language.EN.nameType, R.drawable.bug_locust,
            R.raw.animal_cat_fa, R.drawable.label_bug_locust, TYPE.BUG.nameType, false
        ),
        Animal("silkworm-en", "کرم ابریشم", Language.EN.nameType, R.drawable.bug_silkworm,
            R.raw.animal_cat_fa, R.drawable.label_bug_silkworm, TYPE.BUG.nameType, false
        ),
        Animal("snail-en", "حلزون", Language.EN.nameType, R.drawable.bug_snail,
            R.raw.animal_cat_fa, R.drawable.label_bug_snail, TYPE.BUG.nameType, false
        ),
        Animal("spider-en", "عنکبوت", Language.EN.nameType, R.drawable.bug_spider,
            R.raw.animal_fox_fa, R.drawable.label_bug_spider, TYPE.BUG.nameType, false
        ),

        )

}



