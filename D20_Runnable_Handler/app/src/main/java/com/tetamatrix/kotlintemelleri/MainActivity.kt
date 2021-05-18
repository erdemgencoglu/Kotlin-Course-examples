package com.tetamatrix.kotlintemelleri

import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    var numara = 0
    var runnable: Runnable = Runnable {}
    var handler = Handler(Looper.myLooper()!!)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    //Handler runnable nesnesinin çalıştırması için yardımcı olarak kullanılır
    fun BtnBaslat(view: View) {
        numara = 0
        runnable = object : Runnable {
            override fun run() {
                numara++
                textView.text = "Sayaç: ${numara}"
                handler.postDelayed(runnable, 1000)
            }
        }
        handler.post(runnable)
    }

    fun BtnDurdur(view: View) {
        handler.removeCallbacks(runnable)
        textView.text = "Sayaç: 0"
    }


    //region Activity LifeCycle
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
    } //endregion

}




