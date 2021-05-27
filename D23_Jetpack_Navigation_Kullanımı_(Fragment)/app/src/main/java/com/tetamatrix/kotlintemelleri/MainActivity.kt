package com.tetamatrix.kotlintemelleri

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.tetamatrix.kotlintemelleri.Ekranlar.Fragment1
import com.tetamatrix.kotlintemelleri.Ekranlar.Fragment2
import com.tetamatrix.kotlintemelleri.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    //Viewbinding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    //Fragmet



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




