package com.tetamatrix.kotlintemelleri

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.tetamatrix.kotlintemelleri.Model.Kahraman
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var isim: String = ""
    var meslek: String = ""
    var yas: Int? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun BtnKahramanOlustur(view: View) {
        isim = editTextIsim.text.toString()
        meslek = editTextMeslek.text.toString()
        yas = editTextYas.text.toString().toIntOrNull() //int değilse null döndürür
        if (yas == null) {
            textViewKahraman.text = "Yas alanı karakter içeremez"
        } else {
            val kahraman = Kahraman(isim, meslek, yas!!)
            textViewKahraman.text = "Kahraman adı: ${kahraman.isim} \n Meslek: ${kahraman.meslek} \n Yaş: ${kahraman.yas}"
        }
    }
}




