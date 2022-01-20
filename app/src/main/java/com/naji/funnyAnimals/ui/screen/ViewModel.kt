package com.naji.funnyAnimals.ui.screen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.naji.funnyAnimals.data.Animal
import com.naji.funnyAnimals.data.AnimalData
import com.naji.funnyAnimals.data.animalenum.TYPE
import com.naji.funnyAnimals.data.preferences.PreferenceProvider

class ViewModel(application: Application) : AndroidViewModel(application) {

    private var _animalItems = MutableLiveData(listOf<Animal>())
    val animalItems: LiveData<List<Animal>> = _animalItems

    val backgroundMusicPlaying: LiveData<Boolean> by lazy { _backgroundMusicPlaying }
    private var _backgroundMusicPlaying: MutableLiveData<Boolean> = MutableLiveData()
    private val pref = PreferenceProvider(application)

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
        changeAnimation(item)
        showLabel(item)
    }

    fun musicIconClickHandler() {

        val musicStatus=isMusicPlaying()
        _backgroundMusicPlaying.value = !musicStatus
        saveMusicPlayerStatus(!musicStatus)
    }

    fun isMusicPlaying(): Boolean {
        return pref.getMusicBackgroundStatus()
    }

    fun saveMusicPlayerStatus(isPlay: Boolean) {
        pref.saveMusicBackgroundStatus(isPlay)
    }

    fun init(type: TYPE) {
        _animalItems.value = getAnimalListFromRepo(type)
    }


    private fun getAnimalListFromRepo(type: TYPE): List<Animal> {

        return when (type) {
            TYPE.ANIMAL -> AnimalData.AnimalData
            TYPE.BIRD -> AnimalData.BirdData
            TYPE.BUG -> AnimalData.BugData
            TYPE.AQUATIC -> AnimalData.AquaticData
        }
    }


}