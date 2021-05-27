package com.tetamatrix.kotlintemelleri

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tetamatrix.kotlintemelleri.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    //Viewbinding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //try catch sql islemleri icin
        try {
            val veritabani = this.openOrCreateDatabase("Urunler", Context.MODE_PRIVATE, null)
            veritabani.execSQL("CREATE TABLE IF NOT EXISTS urunler (id INTEGER PRIMARY KEY,isim VARCHAR,fiyat INT)")
            //Insert
            //veritabani.execSQL("INSERT INTO urunler (isim,fiyat) VALUES ('Ayakkabı',100)")
            //veritabani.execSQL("INSERT INTO urunler (isim,fiyat) VALUES ('Tshirt',10)")
            //veritabani.execSQL("INSERT INTO urunler (isim,fiyat) VALUES ('Kapşun',80)")

            //Select
           //val cursor = veritabani.rawQuery("SELECT * FROM urunler WHERE id = 2 ", null)
            val cursor = veritabani.rawQuery("SELECT * FROM urunler", null)

            //Update
            //veritabani.execSQL("UPDATE urunler SET fiyat =250 WHERE id =1")

            //Delete
           // veritabani.execSQL("DELETE FROM urunler WHERE id =1")

            val idColumnIndex = cursor.getColumnIndex("id")
            val isimColumnIndex = cursor.getColumnIndex("isim")
            val fiyatColumnIndex = cursor.getColumnIndex("fiyat")

            while (cursor.moveToNext()) {
                println("ID:${cursor.getInt(idColumnIndex)} isim:${cursor.getString(isimColumnIndex)} fiyat:${
                    cursor.getString(fiyatColumnIndex)
                }")
            }
            cursor.close()

        } catch (exception: Exception) {
            exception.printStackTrace()
        }

    }


    //region Activity LifeCycle
    override fun onStart() {
        super.onStart()
        println("onStart çağırıldı")
    }

    override fun onRestart() {
        super.onRestart()
        println("onRestart çağırıldı")
    }

    override fun onResume() {
        super.onResume()
        println("onResume çağırıldı")
    }

    override fun onStop() {
        super.onStop()
        println("onStop çağırıldı")
    }

    override fun onPause() {
        super.onPause()
        println("onPause çağırıldı")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("onDestroy çağırıldı")
    } //endregion

}




