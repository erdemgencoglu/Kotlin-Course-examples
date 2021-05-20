package com.tetamatrix.onepiecefruits.Helper

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.tetamatrix.onepiecefruits.Model.Fruit
import com.tetamatrix.onepiecefruits.R

class FruitListRecyclerAdapter(val fruitList: ArrayList<Fruit>) :
    RecyclerView.Adapter<FruitListRecyclerAdapter.FruitViewHolder>() {

    class FruitViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    //Layout Bağlama işlemi
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitViewHolder {
        //Infalter,LayoutInflater,MenuInflater
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.rcylview_fruit_item_row, parent, false)
        return FruitViewHolder(itemView)
    }

    //Recyclerview'ın size ını belirler
    override fun getItemCount(): Int {
        return fruitList.size
    }

    override fun onBindViewHolder(holder: FruitViewHolder, positon: Int) {
        //Arayüz nesneleri
        val fruitImage: ImageView = holder.itemView.findViewById(R.id.imgViewFruitImage)
        val fruitName: TextView = holder.itemView.findViewById(R.id.tvFruitName)
        //Değerlerin atanması
        fruitImage.setImageBitmap(fruitList.get(positon).fruitImage)
        fruitName.setText(fruitList.get(positon).fruitName)

    }

}