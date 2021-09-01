package com.tetamatrix.besinlerkitabi.helper.roomService

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.tetamatrix.besinlerkitabi.model.Besin

@Database(entities = arrayOf(Besin::class), version = 1)
abstract class BesinDatabase : RoomDatabase() {
    abstract fun besinDao(): BesinDao


    //Singleton (Tek bit threadin erişmesine izinverilmesi)
    companion object {
        @Volatile
        private var instance: BesinDatabase? = null
        private val lock = Any()
        operator fun invoke(context: Context) = instance ?: synchronized(lock) {
            instance ?: databaseOlustur(context).also {
                instance = it
            }
        }

        private fun databaseOlustur(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            BesinDatabase::class.java, "BESINDATABASE"
        )
            .allowMainThreadQueries()
            .build()
    }

}