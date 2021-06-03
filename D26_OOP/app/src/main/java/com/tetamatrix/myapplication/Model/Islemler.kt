package com.tetamatrix.myapplication.Model

class Islemler {
    //Static polymorphism
    fun carpma(): Int {
        return 0
    }

    fun carpma(a: Int, b: Int): Int {
        return a * b
    }

    fun carpma(a: Int, b: Int, c: Int): Int {
        return a * b * c
    }
}