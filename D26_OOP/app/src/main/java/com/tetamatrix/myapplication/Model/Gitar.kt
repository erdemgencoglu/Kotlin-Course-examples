package com.tetamatrix.myapplication.Model

class Gitar :Enstruman,Dekarasyon{
    var marka: String? = null
    var elektro: Boolean? = null


    override var oda: String
        get() = "Salon"
        set(value) {}

}