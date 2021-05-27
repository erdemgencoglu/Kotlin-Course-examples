package com.tetamatrix.kotlintemelleri

import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.tetamatrix.kotlintemelleri.Ekranlar.Fragment1
import com.tetamatrix.kotlintemelleri.Ekranlar.Fragment2
import com.tetamatrix.kotlintemelleri.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    //Viewbinding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

	//Fragmentlar Activitileri sonlandırmadan farklı pencereler kullanmaya yarar ve buda performans açısından
	//avantaj sağlar (Sonlanan activity e tekrar dönmek gerektiğini düşünelim lifecyle methodları her döndüğümde çalışmak zorunda dır)

    //Fragment1 Btn
    fun Fragment1Open(view: View) {
        //Fragment1 tanımlaması
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val firstFragmnet = Fragment1()
        fragmentTransaction.replace(R.id.frameLayout2, firstFragmnet).commit() // sürekli üstüne ekleme yapar replace kullanılmalıdır

    }

    //Fragment2 Btn
    fun Fragment2Open(view: View) {
        //Fragment1 tanımlaması
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val secondFragmnet = Fragment2()
        fragmentTransaction.replace(R.id.frameLayout2, secondFragmnet).commit()
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




