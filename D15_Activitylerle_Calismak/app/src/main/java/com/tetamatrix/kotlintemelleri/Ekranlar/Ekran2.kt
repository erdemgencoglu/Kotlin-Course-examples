package com.tetamatrix.kotlintemelleri.Ekranlar

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.tetamatrix.kotlintemelleri.R
import kotlinx.android.synthetic.main.activity_ekran2.*

class Ekran2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ekran2)

        val gelenVeri = intent.getStringExtra("ekran1yollanan")
        textView2.text = gelenVeri


    }
}