package com.tetamatrix.myapplication.Model

class Kopek : Hayvan() {
    fun kopek(){
        super.sesCikar()
    }
    override fun sesCikar(){
        println("Köpek sınıfı")
    }
}