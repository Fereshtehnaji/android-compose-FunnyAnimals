package com.naji.funnyAnimals.ui

import androidx.lifecycle.*
import com.naji.funnyAnimals.data.Animal
import com.naji.funnyAnimals.data.AnimalRepository
import com.naji.funnyAnimals.data.animalenum.Language
import com.naji.funnyAnimals.data.animalenum.TYPE
import kotlinx.coroutines.launch

class AnimalViewModel(private val repository: AnimalRepository) : ViewModel() {

    var _animalItems = MutableLiveData(listOf<Animal>())
        private set
    val animalItems: LiveData<List<Animal>> = _animalItems


    val backgroundMusicPlaying: LiveData<Boolean> by lazy { _backgroundMusicPlaying }
    private var _backgroundMusicPlaying: MutableLiveData<Boolean> = MutableLiveData()

    val appLanguage: LiveData<String> by lazy { _appLanguage }
    private var _appLanguage: MutableLiveData<String> = MutableLiveData()

    fun load(type: TYPE) {
        _animalItems.value = repository.getAllAnimalByType().value
    }

    fun fetchAllAnimals(): LiveData<List<Animal>> {
        return repository.getAllAnimalByType()
    }

//    private fun changeAnimation3(animal: Animal) {
//
//        val animals: MutableList<Animal>? = fetchAllAnimals().value?.toMutableList()
//
//        animals?.forEachIndexed { index, it ->
//            val mutableItem = it.copy()
//            mutableItem.isClicked = it == animal
//            animals[index] = mutableItem
//            _animalItems.value = animals
//        }
//
//    }

    private fun changeAnimation(animal: Animal) {


        viewModelScope.launch {

            repository.updateLastSelectedItem(lastStatus = true, newStatus = false)
            animal.isClicked = true
            repository.updateAnimal(animal)
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

    fun changeListLanguage(type: TYPE) {
        languageButtonHandler()
        load(type = type)
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


