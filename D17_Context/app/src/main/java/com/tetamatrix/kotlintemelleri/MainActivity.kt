package com.tetamatrix.kotlintemelleri

import android.content.DialogInterface
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println("onCreate çağırıldı") //Context-> Durum
        //applicationContext --> Uygulama contexti
        //this,this@MainActivity --> Bulunulan sınıfın contexini referans eder


        //Toast, Alert
        Toast.makeText(this, "Hoşgeldin", Toast.LENGTH_LONG).show()
    }


    override fun onStart() {
        super.onStart()
        println("onStart çağırıldı")
    }

    override fun onRestart() {
        super.onRestart()
        println("onRestart çağırıldı")
    }


    override fun onResume() {
        super.onResume()
        println("onResume çağırıldı")
    }

    override fun onStop() {
        super.onStop()
        println("onStop çağırıldı")
    }

    override fun onPause() {
        super.onPause()
        println("onPause çağırıldı")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("onDestroy çağırıldı")
    }

    fun BtnMesajGoster(view: View) {
        val alert = AlertDialog.Builder(this@MainActivity)
        alert.setTitle("Şifre Hatası")
        alert.setMessage("Şifreyi girmediniz,Lütfen doğru giriniz!")
        alert.setCancelable(true)

        //Lambda Gösterimi
        alert.setPositiveButton("EVET", DialogInterface.OnClickListener { dialog, which ->
            Toast.makeText(this, "Baştan Deniyorsunuz", Toast.LENGTH_LONG).show()
        })
        alert.setNegativeButton("Hayır"){dialogInterface,i->
            Toast.makeText(this, "Hayır Seçtiniz", Toast.LENGTH_LONG).show()
        }
        alert.show()
    }
}




