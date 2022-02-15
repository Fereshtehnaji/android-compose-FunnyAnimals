package com.naji.funnyAnimals.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.naji.funnyAnimals.data.animalenum.TYPE

@Entity(tableName="animal_table")
data class Animal(
    @ColumnInfo(name = "animal")
    val animal: String,
    val name: String,
    val language:String,
    val picture: Int,
    val sound: Int,
    val label: Int,
    val type: String,
    var isClicked: Boolean
){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}