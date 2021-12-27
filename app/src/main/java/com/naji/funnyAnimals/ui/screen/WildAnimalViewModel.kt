package com.naji.funnyAnimals.ui.screen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.naji.funnyAnimals.data.Animal
import com.naji.funnyAnimals.data.AnimalData

class WildAnimalViewModel : ViewModel() {

    fun init(){
        updateAnimals(AnimalData.AnimalSample)
    }

    private val animalLiveData = MutableLiveData<List<Animal>>()

    fun getAnimalList(): MutableLiveData<List<Animal>> {
        return animalLiveData
    }

    private fun updateAnimals(animals:List<Animal>){
        animalLiveData.value = animals
    }


    fun clickOnItem(animal: Animal){
        val animalList =AnimalData.AnimalSample
        for(it in animalList){
            if(it!=animal)
                it.animate=false
            else
                it.animate=animal.animate
        }
        updateAnimals(animalList)
    }
}