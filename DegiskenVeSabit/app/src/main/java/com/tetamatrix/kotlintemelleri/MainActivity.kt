package com.tetamatrix.kotlintemelleri

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DersNotlari()
    }
}

// DEĞİŞKENLER
fun DersNotlari() {
    var a = 5      //var değişken tanımlamasından kullanılır = ifadesinden sonraki değişken tipidir.
    var b = 10
    println("a sayısı ile b sayısının çarğımı ${a * b}");   //Logcat kısmına System.out yazarak kolayca bakılabilir

    val x = 10     //val sabit tanimlamasinda kullanilir daha sonra değer atanamaz
    val y = 28
    println("a sayısı ile b sayısının toplamı " + (x + y))
}