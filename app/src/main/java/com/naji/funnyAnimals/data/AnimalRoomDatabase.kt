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
                    "animal_database"
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
        /**
         * Override the onCreate method to populate the database.
         */
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

        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)


        }

        /**
         * Populate the database in a new coroutine.
         * If you want to start with more words, just add them.
         */
        suspend fun populateDatabase(animalDao: AnimalDao) {
            // Start the app with a clean database every time.
            // Not needed if you only populate on creation.
//            animalDao.deleteAll()

            val animalList = AnimalData.AquaticData

            for (animal in animalList)
                animalDao.insert(animal)
        }
    }


}