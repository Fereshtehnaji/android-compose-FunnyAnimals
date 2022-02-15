package com.naji.funnyAnimals.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [Animal::class], version = 1, exportSchema = false)
abstract class AnimalRoomDatabase : RoomDatabase() {

    abstract fun animalDao(): AnimalDao


    companion object {

        @Volatile
        private var INSTANCE: AnimalRoomDatabase? = null

        fun getDatabase(
            context: Context, scope: CoroutineScope
        ): AnimalRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AnimalRoomDatabase::class.java,
                    "animal_database2"
                )
                    .addCallback(AnimalDatabaseCallback(scope))
                    .build()

                INSTANCE = instance

                instance
            }
        }


    }


    private class AnimalDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            // If you want to keep the data through app restarts,
            // comment out the following line.
            INSTANCE?.let { database ->
                scope.launch(Dispatchers.IO) {
                    populateDatabase(database.animalDao())
                }
            }
        }


        suspend fun populateDatabase(animalDao: AnimalDao) {
            // Start the app with a clean database every time.
            // Not needed if you only populate on creation.
//            animalDao.deleteAll()

            val animalList = AnimalData.AnimalData

            for (animal in animalList)
                animalDao.insert(animal)
        }
    }


}