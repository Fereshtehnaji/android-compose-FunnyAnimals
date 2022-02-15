package com.naji.funnyAnimals.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface AnimalDao {

    //    @Query("SELECT * FROM animal_table WHERE type = :type AND language = :language")
    @Query("SELECT * FROM animal_table WHERE language = :language")
    fun getAnimalList(language: String): LiveData<List<Animal>>

    @Query("UPDATE animal_table SET isClicked= :newStatus  WHERE isClicked = :lastStatus ")
    suspend fun updateSelectedAnimals(lastStatus: Boolean, newStatus: Boolean)


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(animal: Animal)

    @Query("DELETE FROM animal_table")
    suspend fun deleteAll()

    @Update()
    suspend fun updateAnimal(vararg animal: Animal)

    @Query("UPDATE animal_table SET isClicked= :status WHERE animal= :animal")
    suspend fun updateAnimal2(animal: String, status: Boolean)
}