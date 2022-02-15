package com.naji.funnyAnimals.data

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.naji.funnyAnimals.data.preferences.PreferenceProvider

class AnimalRepository(
    private val animalDao: AnimalDao,
    private val pref: PreferenceProvider
) {

//    val allAnimal: Flow<List<Animal>> = animalDao.getAnimals(type = type)


    fun getAllAnimalByType(type: String, language: String): LiveData<List<Animal>> =
        animalDao.getAnimalList(type,language)

    @WorkerThread
    suspend fun updateLastSelectedItem(lastStatus: Boolean, newStatus: Boolean) =
        animalDao.updateSelectedAnimals(lastStatus, newStatus)

    @WorkerThread
    suspend fun updateAnimal(animal: Animal) = animalDao.updateAnimal(animal)

    @WorkerThread
    suspend fun updateSelectedItem(name: String, status: Boolean) =
        animalDao.updateSelectedItem(name, status)

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