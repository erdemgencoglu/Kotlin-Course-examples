package com.tetamatrix.myapplication.Model

//open ifadesi kalıtım yapılmak için açık yapmaya yarar
open class Sanatci(isim: String, yas: Int, meslek: String) {

    //Encapsulation    değişkenlerin erişilebilirliği

    var isim: String? = isim
        private set
        get

    var yas: Int? = yas
        private set
        get

    private var meslek: String? = meslek

}