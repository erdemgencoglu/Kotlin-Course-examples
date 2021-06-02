package com.tetamatrix.kotlintemelleri

import android.app.DirectAction
import android.content.Context
import android.opengl.Visibility
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import com.tetamatrix.kotlintemelleri.Ekranlar.TarifDetayFragment
import com.tetamatrix.kotlintemelleri.Ekranlar.TariflerFragment
import com.tetamatrix.kotlintemelleri.Ekranlar.TariflerFragmentDirections
import com.tetamatrix.kotlintemelleri.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    //Viewbinding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    //Navbar menu create
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.navbar_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    //Navbar menu item selected
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.yemekeklemeitem) {
            binding.floatingAcBtn.hide()
            val action = TariflerFragmentDirections.actionTariflerFragmentToTarifEkleFragment("menudengeldim",0)
            Navigation.findNavController(this, R.id.fragmentContainerView).navigate(action)
        }
        return super.onOptionsItemSelected(item)
    }


    fun FloatingButtonEkle(view: View) {
        binding.floatingAcBtn.hide()
        val action = TariflerFragmentDirections.actionTariflerFragmentToTarifEkleFragment("menudengeldim",0)
        Navigation.findNavController(this, R.id.fragmentContainerView).navigate(action)
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




