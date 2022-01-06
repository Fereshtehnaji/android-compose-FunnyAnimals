package com.naji.funnyAnimals.ui.screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.naji.funnyAnimals.data.Animal
import com.naji.funnyAnimals.data.AnimalData
import com.naji.funnyAnimals.data.TYPE

class WildAnimalViewModel : ViewModel() {

    private var _animalItems = MutableLiveData(listOf<Animal>())
    val animalItems: LiveData<List<Animal>> = _animalItems


    private fun playSound(item: Animal) {

    }

    private fun stopSound(item: Animal) {

    }

    private fun changeAnimation(animal: Animal) {

        val animals: MutableList<Animal>? = _animalItems.value?.toMutableList()

        animals?.forEachIndexed { index, it ->
            val mutableItem = it.copy()
            mutableItem.isClicked = it == animal
            animals[index] = mutableItem
            _animalItems.value = animals
        }

    }

    private fun showLabel(item: Animal) {

    }

    fun clickHandler(item: Animal) {
        stopSound(item)
        playSound(item)
        changeAnimation(item)
        showLabel(item)
    }


    fun init(type: TYPE) {
        _animalItems.value = getAnimalListFromRepo(type)
    }


    private fun getAnimalListFromRepo(type: TYPE): List<Animal> {

        return when (type) {
            TYPE.ANIMAL -> AnimalData.AnimalData
            TYPE.BIRD -> AnimalData.BirdData
            TYPE.BUG -> AnimalData.BugData
            TYPE.Aquatic -> AnimalData.AquaticData
        }
    }



}