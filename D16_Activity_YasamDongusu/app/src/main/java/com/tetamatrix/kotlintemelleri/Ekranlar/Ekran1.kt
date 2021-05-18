package com.tetamatrix.kotlintemelleri.Ekranlar

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.tetamatrix.kotlintemelleri.MainActivity
import com.tetamatrix.kotlintemelleri.R

class Ekran1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ekran1)
    }

    fun BtnGeriDon(view: View) {
        var intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}