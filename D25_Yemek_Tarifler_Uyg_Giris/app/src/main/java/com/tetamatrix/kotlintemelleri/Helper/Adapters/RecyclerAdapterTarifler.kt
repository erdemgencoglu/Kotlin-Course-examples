package com.tetamatrix.kotlintemelleri.Helper.Adapters

import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.tetamatrix.kotlintemelleri.Ekranlar.TariflerFragment
import com.tetamatrix.kotlintemelleri.Ekranlar.TariflerFragmentDirections
import com.tetamatrix.kotlintemelleri.R
import java.sql.Blob

class RecyclerAdapterTarifler(val tarifListesi: ArrayList<String>, val tarifIdListesi: ArrayList<Int>, val tarifImageListesi: ArrayList<ByteArray>) :
    RecyclerView.Adapter<RecyclerAdapterTarifler.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.rcycler_item_tarifler, parent, false)
        return ViewHolder(view);
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tarifImage: ImageView = holder.itemView.findViewById(R.id.rcyler_item_tarifler_tarifImage)
        val tarifIsmi: TextView = holder.itemView.findViewById(R.id.rcyler_item_tarifler_tarifAdi)
        tarifIsmi.text = tarifListesi[position]
        val byteArray = tarifImageListesi[position]
        val bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size)
        tarifImage.setImageBitmap(bitmap)
        //
        holder.itemView.setOnClickListener {
            val action = TariflerFragmentDirections.actionTariflerFragmentToTarifEkleFragment("recyclerdangeldim", tarifIdListesi[position])
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return tarifListesi.size
    }

}