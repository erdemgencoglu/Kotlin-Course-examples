package com.tetamatrix.kotlintemelleri.Ekranlar

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.tetamatrix.kotlintemelleri.R
import kotlinx.android.synthetic.main.activity_ekran1.*

class Ekran1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ekran1)
    }


    fun BtnGonder(view: View) {
        val yollananVeri = edtYollananVeri.text.toString()
        var intent = Intent(this, Ekran2::class.java)
        intent.putExtra("ekran1yollanan", yollananVeri)
        startActivity(intent)

    }
}