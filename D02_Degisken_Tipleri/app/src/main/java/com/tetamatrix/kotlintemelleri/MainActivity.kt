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

// Veri Tipleri
fun DersNotlari() {
    println("---------- Int ----------")
    var sayi = 10         //Initializin deger olarak tanımlama
    var sayi2 = 3
    val sayi3 = 18
    val intsayi: Int      //Değişkenin tipinin ne olacağını tanımlama
    intsayi = 12
    println(sayi3)

    println("---------- Long ----------")
    var sayi4_0_long = 100
    var sayi4_1: Long
    sayi4_1 = 3000000000
    println(sayi4_1)

    println("---------- Double & FLoat ----------")
    var pi = 3.14
    println(pi * 2)
    val floatPi: Float = 3.14f
    println(floatPi)
    println(pi / 2)

    println("---------- String ----------")
    val adim = "Ali"
    var sonuc = "Yapılan işlem sonucu"
    var sb: StringBuilder = StringBuilder()
    sb.append("String birleştirme " + adim + sonuc + "\n")
    sb.append("Uzunluk " + sonuc.length + "\n")
    sb.append("Substring by index " + sonuc.substring(2) + "\n")
    sb.append("Substring 2 index  " + sonuc.substring(0, 5) + "\n")
    sb.append("2 string eşitmi " + sonuc.equals(adim) + "\n")
    sb.append("String verilen indexi getirme " + sonuc.get(6) + "\n")
    sb.append("Stringte verilen indexteki charı silme " + sonuc.drop(5) + "\n")
    sb.append("Stringin sondan verilen index kadar silme " + sonuc.dropLast(6) + "\n")
    sb.append("String verilen prefix ile başlıyormu? " + sonuc.startsWith("Y") + "\n")
    sb.append("String verilen prefix ile bitiyormu? " + sonuc.endsWith("li") + "\n")
    println("${sb.toString()}")

    println("---------- Boolean ----------")
    var benimBoolean = true
    benimBoolean = false
    var bl: Boolean

    // <  -> küçüktür
    // >  -> büyüktür
    // == -> eşittir
    // != -> eşit değildir
    // <= -> küçük eşittir
    // >= -> büyük eşittir
    // && -> ve
    // || -> veya
    println(3<5)
}