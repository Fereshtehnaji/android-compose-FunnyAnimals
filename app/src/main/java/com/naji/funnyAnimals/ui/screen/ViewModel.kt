package com.naji.funnyAnimals.ui.screen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.naji.funnyAnimals.data.Animal
import com.naji.funnyAnimals.data.AnimalData
import com.naji.funnyAnimals.data.animalenum.Language
import com.naji.funnyAnimals.data.animalenum.TYPE
import com.naji.funnyAnimals.data.preferences.PreferenceProvider

class ViewModel(application: Application) : AndroidViewModel(application) {

    private var _animalItems = MutableLiveData(listOf<Animal>())
    val animalItems: LiveData<List<Animal>> = _animalItems

    val backgroundMusicPlaying: LiveData<Boolean> by lazy { _backgroundMusicPlaying }
    private var _backgroundMusicPlaying: MutableLiveData<Boolean> = MutableLiveData()

    val appLanguage: LiveData<String> by lazy { _appLanguage }
    private var _appLanguage: MutableLiveData<String> = MutableLiveData()

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

    private fun showLabel() {

    }

    fun clickHandler(item: Animal) {
        changeAnimation(item)
        showLabel()
    }

    fun musicIconClickHandler() {

        val musicStatus = isMusicPlaying()
        _backgroundMusicPlaying.value = !musicStatus
        saveMusicPlayerStatus(!musicStatus)
    }


    fun isMusicPlaying(): Boolean {
        return pref.getMusicBackgroundStatus()
    }

    private fun saveMusicPlayerStatus(isPlay: Boolean) {
        pref.saveMusicBackgroundStatus(isPlay)
    }


    fun languageIconHandler() {
        val appLanguage = getLanguageOfApp()
        val changedLanguage: String = if (appLanguage == Language.FA.nameType)
            Language.EN.nameType
        else Language.FA.nameType
        _appLanguage.value = changedLanguage
        saveLanguageStatus(changedLanguage)
    }

    fun getLanguageOfApp(): String {
        return pref.getLanguageStatus()
    }

    private fun saveLanguageStatus(language: String) {
        pref.saveLanguageStatus(language)

    }

    fun init(type: TYPE) {
        _animalItems.value = getAnimalListFromRepo(type, getLanguageOfApp())
    }


    private fun getAnimalListFromRepo(type: TYPE, language: String): List<Animal> {

        return if (language == Language.FA.nameType) {
            when (type) {
                TYPE.ANIMAL -> AnimalData.AnimalData
                TYPE.BIRD -> AnimalData.BirdData
                TYPE.BUG -> AnimalData.BugData
                TYPE.AQUATIC -> AnimalData.AquaticData
            }
        } else {
            when (type) {
                TYPE.ANIMAL -> AnimalData.AnimalDataEn
                TYPE.BIRD -> AnimalData.BirdDataEn
                TYPE.BUG -> AnimalData.BugDataEn
                TYPE.AQUATIC -> AnimalData.AquaticDataEn
            }
        }
    }


}