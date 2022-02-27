package com.naji.funnyAnimals.ui

import androidx.lifecycle.*
import com.naji.funnyAnimals.data.Animal
import com.naji.funnyAnimals.data.AnimalRepository
import com.naji.funnyAnimals.data.animalenum.Language
import com.naji.funnyAnimals.data.animalenum.TYPE
import kotlinx.coroutines.launch

class AnimalViewModel(private val repository: AnimalRepository) : ViewModel() {

    val backgroundMusicPlaying: LiveData<Boolean> by lazy { _backgroundMusicPlaying }
    private var _backgroundMusicPlaying: MutableLiveData<Boolean> = MutableLiveData()

    val appLanguage: LiveData<String> by lazy { _appLanguage }
    private var _appLanguage: MutableLiveData<String> = MutableLiveData()

    fun fetchAllAnimals(type: TYPE): LiveData<List<Animal>> {
        return repository.getAllAnimalByType(type.nameType,getLanguageOfApp())
    }


    private fun changeAnimation(animal: Animal) {
        viewModelScope.launch {

            repository.updateLastSelectedItem(lastStatus = true, newStatus = false)
            val mutableItem :Animal = animal.copy()
            mutableItem.isClicked = true
            repository.updateSelectedItem(mutableItem.name,true)
        }


    }

    fun unSelectLastItem(){
        viewModelScope.launch {
            repository.updateLastSelectedItem(lastStatus = true, newStatus = false)
        }
    }

    fun clickHandler(item: Animal) {
        changeAnimation(item)
    }

    fun musicButtonHandler() {

        val musicStatus = repository.isMusicPlaying()
        _backgroundMusicPlaying.value = !musicStatus
        repository.saveMusicPlayerStatus(!musicStatus)
    }


    fun languageButtonHandler() {
        val appLanguage = repository.getLanguageOfApp()
        val changedLanguage = if (appLanguage == Language.FA.nameType)
            Language.EN.nameType
        else Language.FA.nameType
        _appLanguage.value = changedLanguage
        repository.saveLanguageStatus(changedLanguage)
    }

    fun changeListLanguage() {
        languageButtonHandler()
    }


    fun isMusicPlaying(): Boolean {
        return repository.isMusicPlaying()
    }

    fun getLanguageOfApp(): String {
        return repository.getLanguageOfApp()
    }

}

class AnimalViewModelFactory(private val repository: AnimalRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AnimalViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return AnimalViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

