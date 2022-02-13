package com.naji.funnyAnimals.data

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.naji.funnyAnimals.data.preferences.PreferenceProvider

class AnimalRepository(
    private val animalDao: AnimalDao,
    private val pref: PreferenceProvider
) {

//    val allAnimal: Flow<List<Animal>> = animalDao.getAnimals(type = type)


    fun getAllAnimalByType(): LiveData<List<Animal>> = animalDao.getAnimalList()

    @WorkerThread
    suspend fun updateSelectedAnimals(isClicked:Boolean, newIsClicked:Boolean)
    = animalDao.updateSelectedAnimals(isClicked,newIsClicked)

    @WorkerThread
    suspend fun updateAnimal(animal: Animal) = animalDao.updateAnimal(animal)

    fun isMusicPlaying(): Boolean {
        return pref.getMusicBackgroundStatus()
    }

    fun saveMusicPlayerStatus(isPlay: Boolean) {
        pref.saveMusicBackgroundStatus(isPlay)
    }

    fun getLanguageOfApp(): String {
        return pref.getLanguageStatus()
    }

    fun saveLanguageStatus(language: String) {
        pref.saveLanguageStatus(language)

    }
}