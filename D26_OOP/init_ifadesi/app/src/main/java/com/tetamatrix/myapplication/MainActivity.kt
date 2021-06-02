package com.tetamatrix.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tetamatrix.myapplication.Model.Kullanici

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println("-------------Sınıflar------------")
        val kullanici=Kullanici("Erdem",28)

    }
}