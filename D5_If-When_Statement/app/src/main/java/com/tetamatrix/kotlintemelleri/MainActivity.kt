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

//if,When kontrolleri
fun DersNotlari() {
    println("------------ If Statements (Eğer kontrolü) ------------")
    var skor = 10;
    if (skor < 5)
        println("Ortalama puan")
    if (skor >= 10)
        println("En iyi skor")
    else if (skor > 3)
        print("Düşük puan")
    else
        print("Yeniden oyna")

    println("------------ When(Switch case) Statements ------------")
    var not = 0
    when (not) {
        0 -> {
            println("a")
        }
        2 -> {
            println("b")
        }
        3 -> {
            println("c")
        }
        4 -> {
            println("d")
        }
        else -> {
            println("farklı")
        }
    }
    //farklı yazım
    when (not) {
        0 -> println("a")
        2 -> println("b")
        3 -> println("c")
        4 -> println("d")
    }

}