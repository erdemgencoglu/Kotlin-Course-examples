package com.tetamatrix.myapplication.Model

class Kullanici :Insan {
    var isim: String? = null
    var yas: Int? = null
    //initten sonra çağırılır
    constructor(isim:String,yas:Int){
        this.isim=isim
        this.yas=yas
        println("constructer çağırıldı.")
    }
    //ilk çağırılır
    init {
        println("init çağırıldı.")
    }

}