package com.naji.funnyAnimals.ui.screen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.naji.funnyAnimals.data.Animal
import com.naji.funnyAnimals.data.AnimalData
import com.naji.funnyAnimals.data.TYPE

class WildAnimalViewModel : ViewModel() {


    fun init(type: TYPE) {
        updateAnimals(getAnimalListFromRepo(type = type))
    }


    private fun getAnimalListFromRepo(type: TYPE): List<Animal> {

        return when (type) {
            TYPE.ANIMAL -> AnimalData.AnimalData
            TYPE.BIRD -> AnimalData.BirdData
            TYPE.BUG -> AnimalData.BugData
            TYPE.Aquatic -> AnimalData.BirdData
        }
    }

    private val animalLiveData = MutableLiveData<List<Animal>>()

    fun getAnimalList(): MutableLiveData<List<Animal>> {
        return animalLiveData
    }

    private fun updateAnimals(animals: List<Animal>) {
        animalLiveData.value = animals
    }


    fun clickOnItem(animal: Animal, type: TYPE) {
        val animalList = getAnimalListFromRepo(type = type)
        for (it in animalList) {
            if (it != animal)
                it.isClicked = false
            else
                it.isClicked = animal.isClicked
        }

        updateAnimals(animalList)
    }
}