package com.tetamatrix.kotlintemelleri

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {
    var sayi1: Int? = null
    var sayi2: Int? = null
    var yapilanIslem: String? = null
    var sonuc: Any? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    //Toplama butonu click
    fun BtnTopla(view: View) {
        sayi1 = editTextSayi1.text.toString().toIntOrNull();
        sayi2 = editTextSayi2.text.toString().toIntOrNull();
        if (sayi1 == null || sayi2 == null) {
            Toast.makeText(this, getString(R.string.sayiAlaniHatali).toString(), Toast.LENGTH_SHORT)
                .show()
        } else {
            sonuc = (sayi1!! + sayi2!!)
            yapilanIslem = "${sayi1} + ${sayi2} = ${sonuc.toString()}"
            textViewSonuc.text="Sonuç: "+sonuc.toString()
            textViewYapilanIslem.text="Yapılan işlem :\n "+yapilanIslem
        }
    }
    //Çıkarma butonu click
    fun BtnCikar(view: View) {
        sayi1 = editTextSayi1.text.toString().toIntOrNull();
        sayi2 = editTextSayi2.text.toString().toIntOrNull();
        if (sayi1 == null || sayi2 == null) {
            Toast.makeText(this, getString(R.string.sayiAlaniHatali).toString(), Toast.LENGTH_SHORT)
                .show()
        } else {
            sonuc = (sayi1!! - sayi2!!)
            yapilanIslem = "${sayi1} - ${sayi2} = ${sonuc.toString()}"
            textViewSonuc.text="Sonuç: "+sonuc.toString()
            textViewYapilanIslem.text="Yapılan işlem :\n "+yapilanIslem
        }
    }
    //Çarpma butonu click
    fun BtnCarp(view: View) {
        sayi1 = editTextSayi1.text.toString().toIntOrNull();
        sayi2 = editTextSayi2.text.toString().toIntOrNull();
        if (sayi1 == null || sayi2 == null) {
            Toast.makeText(this, getString(R.string.sayiAlaniHatali).toString(), Toast.LENGTH_SHORT)
                .show()
        } else {
            sonuc = (sayi1!! * sayi2!!)
            yapilanIslem = "${sayi1} * ${sayi2} = ${sonuc.toString()}"
            textViewSonuc.text="Sonuç: "+sonuc.toString()
            textViewYapilanIslem.text="Yapılan işlem :\n "+yapilanIslem
        }
    }
    //Bolme butonu click
    fun BtnBol(view: View) {
        sayi1 = editTextSayi1.text.toString().toIntOrNull();
        sayi2 = editTextSayi2.text.toString().toIntOrNull();
        if (sayi1 == null || sayi2 == null) {
            Toast.makeText(this, getString(R.string.sayiAlaniHatali).toString(), Toast.LENGTH_SHORT)
                .show()
        } else {
            sonuc = (sayi1!!.toDouble() / sayi2!!.toDouble())
            yapilanIslem = "${sayi1} / ${sayi2} = ${sonuc.toString()}"
            textViewSonuc.text="Sonuç: "+sonuc.toString()
            textViewYapilanIslem.text="Yapılan işlem :\n "+yapilanIslem
        }
    }


}




