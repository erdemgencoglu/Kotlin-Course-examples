package com.tetamatrix.myapplication.Model

class OzelSanatci(isim: String, yas: Int, meslek: String) : Sanatci(isim, yas, meslek) {

    fun sarkiSoyle(){
        println("sarkı söyleniyor...")
    }
}