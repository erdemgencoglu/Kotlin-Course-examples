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

//Döngüler
fun DersNotlari() {
    println("----------- For Döngüsü ----------")
    val numaralar = arrayListOf<Int>(1, 2, 3, 4, 5, 6, 8, 9, 10, 12)
    for (item in numaralar) {
        println("Şuanki rakam ${item}")
    }
    //indexleri verir
    for (index in numaralar.indices) {
    }
    //ranged for
    for (b in 0..9) {
    }

    numaralar.forEach() {
        println(it)
    }
    println("----------- While Döngüsü ----------")
    var i = 0
    while (i < 4) {
        println("i ${i}")
        i++
    }
}