package com.naji.funnyAnimals.ui

import android.app.Application
import com.naji.funnyAnimals.data.AnimalRepository
import com.naji.funnyAnimals.data.AnimalRoomDatabase
import com.naji.funnyAnimals.data.preferences.PreferenceProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class AnimalApplication : Application() {

    private val applicationScope = CoroutineScope(SupervisorJob())

    private val database by lazy { AnimalRoomDatabase.getDatabase(this, applicationScope) }
    private val pref by lazy { PreferenceProvider(this) }

    val repository by lazy {
        AnimalRepository(database.animalDao(), pref)
    }
}
