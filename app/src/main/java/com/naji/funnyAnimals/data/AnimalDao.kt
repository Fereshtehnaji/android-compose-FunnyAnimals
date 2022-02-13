package com.naji.funnyAnimals.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface AnimalDao {

    @Query("SELECT * FROM animal_table")
    fun getAnimalList(): LiveData<List<Animal>>

    @Query("UPDATE animal_table SET isClicked= :newIsClicked  WHERE isClicked = :isClicked ")
    suspend fun updateSelectedAnimals( isClicked: Boolean, newIsClicked:Boolean)


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(animal: Animal)

    @Query("DELETE FROM animal_table")
    suspend fun deleteAll()

    @Update()
    suspend fun updateAnimal(vararg animal: Animal)
}