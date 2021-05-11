package com.tetamatrix.kotlintemelleri.Model

class SuperKahraman {
    //Property(Variables)
    var isim = ""
    var meslek = ""
    var yas = 0

    //Constructer empty
    constructor() {
    }

    //Constructer variable
    constructor(isim: String, meslek: String, yas: Int) {
        this.isim = isim
        this.meslek = meslek
        this.yas = yas
    }
}