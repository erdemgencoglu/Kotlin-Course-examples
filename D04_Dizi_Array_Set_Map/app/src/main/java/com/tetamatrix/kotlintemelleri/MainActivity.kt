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

//Koleksiyonlar, Diziler ,ArrayList
fun DersNotlari() {
    println("------------- Dizi -------------")
    var degisken = "genç"
    var benimList = arrayOf("Atıl", "Erdem", degisken, "Ahmet")
    println(benimList[0])
    println(benimList.get(2))
    benimList.set(0, "Deu")
    println(benimList.get(0))

    val doubleDizisi = arrayOf(1.2, 5.8, 6.3)
    val doubleDizisi_2 = doubleArrayOf(7.8, 1.1)
    val intDizi = intArrayOf(5, 1, 6, 0)
    val karisikDizi = arrayOf("Erdem", 10, 1.5, true, false, "gençoğlu")

    println("------------- ArrayList -------------")
    var arrayList = arrayListOf<String>("Atıl")
    var arrayList1 = arrayListOf<Int>(1, 2, 3)
    var arrayList2 = arrayListOf<String>("1", "6", "8")
    var arrayList3 = arrayListOf<Any>()
    arrayList.add("Erdem")
    arrayList.get(0)
    arrayList.addAll(arrayList2)
    arrayList3.addAll(arrayList)
    arrayList3.addAll(arrayList1)

    var intArrayList = ArrayList<Int>()
    intArrayList.add(1)
    intArrayList.add(2)
    println(arrayList3.get(3))

    println("--------------- Set ---------------")
    val ornekDizi = arrayOf(7, 8, 9, 9, 9, 8, 10)
    println("index 2: ${ornekDizi[2]}")
    println("index 3: ${ornekDizi[3]}")

    val benimSet = setOf<Int>(7, 8, 8, 9, 9)
    println(benimSet.size)
    benimSet.forEach {
        println(it)
    }
    val digerSet = HashSet<String>()
    digerSet.add("a")
    digerSet.add("b")
    digerSet.add("c")

    println("--------------- Map ---------------")
    val yemekKaloriMap = hashMapOf<String, Int>()
    yemekKaloriMap.put("a", 5)
    yemekKaloriMap.put("b", 1)
    yemekKaloriMap.put("c", 8)

    val yemekMap = hashMapOf<String, String>("Pilav" to "50kcal", "Çorba" to "5kcal")
    println(yemekKaloriMap.get("a"))
    println(yemekMap.get("Pilav"))
}