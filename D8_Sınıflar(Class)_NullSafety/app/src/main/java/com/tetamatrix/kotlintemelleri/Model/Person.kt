package com.tetamatrix.kotlintemelleri.Model

//Primary constructer
class Person(var isim: String, var meslek: String, var yas: Int) {
    private var sacRengi: String = ""

    //Access Levels -Erişebilirlik seviyesi
    //-> public
    //-> private
    //-> internal
    //-> protected
    fun PublicFonksyion() {
        println("public")
    }

    //GET
    fun SacRenginiGetir(): String {
        PrivateFonksyion("Sari")
        return this.sacRengi
    }

    //SET (Değişken private tanımlandıysa set fonksiyonu yazmaya gerek yok direk get fonksiyonu yaz)
    private fun PrivateFonksyion(renk: String) {
        sacRengi = renk
        println("private")
        println("Saç rengi ${this.sacRengi} yapıldı")
    }


}