package com.tetamatrix.onepiecefruits

import android.graphics.BitmapFactory
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import com.tetamatrix.onepiecefruits.Helper.FruitListRecyclerAdapter
import com.tetamatrix.onepiecefruits.Model.Fruit
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var fruitList = ArrayList<Fruit>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var opeopeBitmap =
            BitmapFactory.decodeResource(applicationContext.resources, R.drawable.ope_ope)
        var sorosoro =
            BitmapFactory.decodeResource(applicationContext.resources, R.drawable.sorunomi)
        var fruit = Fruit(opeopeBitmap, "", "Ope ope", "", ArrayList(), "", "", "")
        var fruit2 = Fruit(sorosoro, "", "soro soro", "", ArrayList(), "", "", "")


        fruitList.add(fruit)
        fruitList.add(fruit2)


        //RecylerView Adapter
        val layoutManager = LinearLayoutManager(this)
        rclyViewFruitList.layoutManager = layoutManager
        val adapter = FruitListRecyclerAdapter(fruitList)
        rclyViewFruitList.adapter = adapter

    }

    //Verimsiz imageler ile çalışmak

}

