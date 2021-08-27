package com.tetamatrix.kotlintemelleri

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DersNotlari()
    }
}

// Veri Dönüşümleri - Cast işlemleri
// toLong,toString,toInt,toDouble...
fun DersNotlari() {

    var benimInt = 20
    var long_cevrilmis = benimInt.toLong()

    println(long_cevrilmis)

    var kullaniciYasi = "50"
    var kullaniciInt = kullaniciYasi.toInt()
    println(kullaniciInt)
}