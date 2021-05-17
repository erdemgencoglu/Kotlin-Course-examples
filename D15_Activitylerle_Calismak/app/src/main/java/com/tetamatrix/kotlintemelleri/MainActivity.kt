package com.tetamatrix.kotlintemelleri

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.tetamatrix.kotlintemelleri.Ekranlar.Ekran1
import com.tetamatrix.kotlintemelleri.Ekranlar.Ekran2


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun Ekran1Btn(view: View) {
        val intent = Intent(this, Ekran1::class.java)
        startActivity(intent)
    }

    fun Ekran2Btn(view: View) {
        val intent = Intent(this, Ekran2::class.java)
        startActivity(intent)
    }
}




