package com.tetamatrix.kotlintemelleri

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.tetamatrix.kotlintemelleri.Model.Person
import com.tetamatrix.kotlintemelleri.Model.SuperKahraman
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DersNotlari()
    }
}

//Methodlar (Fonksiyonlar)
fun DersNotlari() {
    var batman = SuperKahraman()
    batman.isim = "Batman"
    batman.meslek = "Punisher"
    batman.yas = 50
    println("${batman.isim} ${batman.meslek} ${batman.yas}")

    var strange = SuperKahraman("Dr.Strange", "Doctor", 40)
    println("İsim" + strange.isim + " Meslek" + strange.meslek + " Yas" + strange.yas)

    var primaryConst = Person("Erdem", "Ceng", 28)
    println("İsim " + primaryConst.isim + " Meslek" + primaryConst.meslek + " Yas" + primaryConst.yas)
    primaryConst.PublicFonksyion()
    primaryConst.SacRenginiGetir()

    //Null,Nullability, Null Safety
    var benimString: String?
    benimString = "Erdem"

    var benimYasim: Int? = null
    println(benimYasim)
    //benimYasim=2

    //NULL SAFETY YONTEMLER
    //1
    if (benimYasim != null) {
        println(benimYasim * 2)
    } else {
        println("Yaş değeri null")
    }
    //2
    // !! -> null olmayacak, ? -> null olabilir
    //println(benimYasim!!.minus(2))//null gelirse patlar
    println(benimYasim?.minus(5))
    //3
    //elvis operatörü
    val sonuc = benimYasim?.minus(2) ?: 10

    //4
    //Let
    benimYasim?.let {
        println(it * 5)
    }
}


