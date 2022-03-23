package com.naji.funnyAnimals.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "animal_table")
data class Animal(
    val name: String,
    val title: String,
    val language: String,
    val shape: Int,
    val sound: Int,
    val type: String,
    var isClicked: Boolean
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}