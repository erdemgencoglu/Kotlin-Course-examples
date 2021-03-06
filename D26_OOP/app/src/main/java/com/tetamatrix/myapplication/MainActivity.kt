package com.tetamatrix.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tetamatrix.myapplication.Model.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println("-------------Sınıflar (Init)------------")
        val kullanici = Kullanici("Erdem", 28)

        println("-------------Encapsulation (get,set private level)------------")
        val sanatci = Sanatci("Erdem", 28, "Mühendis")
        println(sanatci.isim)
        //sanatci.isim="Temel"
        //println(sanatci.isim)

        println("-------------Inheritance (Kalıtım,Super)------------")
        val mehmet = OzelSanatci("mehmet", 40, "Tiyatrocu")
        mehmet.sarkiSoyle()

        println("-------------Polymorphism (aynı isme sahip fonksiyon tanımlama)------------")
        //Statik Polymorphism
        val islemler = Islemler()
        println(islemler.carpma())
        println(islemler.carpma(2, 3))
        println(islemler.carpma(2, 3, 4))
        //Dinamik Polymorphism
        val kedi = Hayvan()
        kedi.sesCikar()
        val barley = Kopek()
        barley.sesCikar()//Super class ile kopek clasında aynı ada sahip fonksiyonlar var ise override ile kullanılır ve open yapılır
        barley.kopek()
        println("-------------Abstraction & Interface------------")
        // abstactiion super classa erişilmesini engellemek için kullanılır
        kullanici.Insan()
        var gitar = Gitar()
        gitar.marka = "Gitar Markası"
        gitar.elektro = true
        gitar.bilgi()
        println(gitar.oda)
        println("-------------Lambda Gösterimleri (Expressions)------------")
        yazdir("test")
        val yazdirLambda = { gonderilenDeg: String -> println(gonderilenDeg) }
        yazdirLambda("test lambda")
        val carpmaIslemilambda = { a: Int, b: Int -> a * b }
        println(carpmaIslemilambda(6, 7))

        val carpmaLambdaV2: (Int, Int) -> Int = { a, b -> a * b }
        println(carpmaLambdaV2(6, 7))
    }

    fun yazdir(string: String) {
        println(string)
    }
}