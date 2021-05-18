package com.tetamatrix.kotlintemelleri

import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    //var sharedPreferences: SharedPreferences? = null
    lateinit var sharedPreferences: SharedPreferences
    var saklananKulAdi: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //SharedPreferences instance
        sharedPreferences = this.getSharedPreferences("com.tetamatrix.kotlintemelleri",
            MODE_PRIVATE) //kaydedilen varsa getir
        saklananKulAdi = sharedPreferences.getString("kulAdi", "")
        if (saklananKulAdi != null) textView.setText("Kaydedilen kuladi : $saklananKulAdi")
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

    fun BtnKaydet(view: View) {
        val kullaniciAdi = edtKulAdi.text.toString()
        if (kullaniciAdi == "") {
            Toast.makeText(this, "Lütfen kullanıcı adı giriniz", Toast.LENGTH_LONG).show()
        } else {
            sharedPreferences.edit().putString("kulAdi", kullaniciAdi).apply()
            textView.setText("Kaydedilen kuladi : $saklananKulAdi")
        }
    }

    fun BtnSil(view: View) {
        var kulAdi = sharedPreferences.getString("kulAdi", "")
        if (kulAdi != null) {
            textView.text = "Kaydedilen kullanici adi:"
            sharedPreferences.edit().remove("kulAdi").apply()
        }
    }
}




