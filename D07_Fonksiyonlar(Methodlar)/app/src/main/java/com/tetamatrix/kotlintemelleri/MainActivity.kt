package com.tetamatrix.kotlintemelleri

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DersNotlari()
        ParametreliFonksiyon(1, "Kelime")
        var sonuc = Toplama(5, 8)

    }
}

//Methodlar (Fonksiyonlar)
fun DersNotlari() {
    println("----- Unit (Void) Değer döndürmeyen-------")
    println("İlk fonksiyon parametresiz")
}

fun ParametreliFonksiyon(a: Int, b: String) {
    println("Paremetre 1 ${a} \n ikinci parametre ${b}")
}

fun Toplama(a: Int, b: Int): Int {
    println("----- Int değer döndüren -------")
    return a + b
}

fun Bolme(a: Int, b: Int): Double {
    println("----- Double değer döndüren -------")
    return a.toDouble() / b
}

fun Dogruluk(a: Int, b: Int): Boolean {
    println("----- Double değer döndüren -------")
    return a == b
}
