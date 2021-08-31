package com.tetamatrix.besinlerkitabi.Helper.RoomService

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.tetamatrix.besinlerkitabi.Model.Besin

@Dao
interface BesinDao {

    //Data Access Object
    //------------------

    //Insert -> Room ,insert into
    //suspend -> coroutine scope
    //vararg ->birden fazla ve istediğimiz sayıda besin
    //List<Long> ->bize insert edilen idleri döndürücek (uuid)

    //INSERT
    @Insert
    fun insertAll(vararg besin: Besin): List<Long>

    //SELECT
    @Query("SELECT * FROM besin")
    suspend fun getAllBesin(): List<Besin>

    //SELECT WITH FILTER
    @Query("SELECT * FROM besin WHERE uuid=:besinId")
    suspend fun getBesin(besinId: Int): Besin

    //DELETE
    @Query("DELETE FROM besin WHERE isim=:besinIsim")
    suspend fun deleteBesin(besinIsim: String): Int

    //DELETEALL
    @Query("DELETE FROM besin")
    suspend fun deleteAllBesin()
}