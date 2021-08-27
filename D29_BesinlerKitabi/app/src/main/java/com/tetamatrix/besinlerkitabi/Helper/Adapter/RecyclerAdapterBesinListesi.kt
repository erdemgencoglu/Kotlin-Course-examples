package com.tetamatrix.besinlerkitabi.Helper.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.tetamatrix.besinlerkitabi.Model.Besin
import com.tetamatrix.besinlerkitabi.R
import com.tetamatrix.besinlerkitabi.View.BesinListesiFragmentDirections

class RecyclerAdapterBesinListesi(val besinListesi: ArrayList<Besin>) : RecyclerView.Adapter<RecyclerAdapterBesinListesi.BesinViewHolder>() {

    class BesinViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BesinViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.fragment_besin_listesi_rcyclerview_row, parent, false)
        return BesinViewHolder(view)
    }

    override fun onBindViewHolder(holder: BesinViewHolder, position: Int) {
        //declare
        val besinRowImage: ImageView = holder.itemView.findViewById(R.id.imageViewBesinListesiItemBesinImage)
        val besinAdi: TextView = holder.itemView.findViewById(R.id.textViewBesinListesiItemBesinAdi)
        val besinKalori: TextView = holder.itemView.findViewById(R.id.textViewBesinListesiItemKalori)
        //setting
        besinAdi.text = besinListesi[position].isim
        besinKalori.text = besinListesi[position].kalori

        //liste tıklama olayı
        holder.itemView.setOnClickListener {
            val action = BesinListesiFragmentDirections.actionBesinListesiFragmentToBesinDetayFragment(0)
            Navigation.findNavController(it).navigate(action)
        }

    }

    override fun getItemCount(): Int {
        return besinListesi.size
    }

    //Listeyi Güncelleme(Activityden yapmaktansa burada daha toplu olur)
    fun besinlistesiGuncelle(guncelBesinListes: ArrayList<Besin>) {
        besinListesi.clear()
        besinListesi.addAll(guncelBesinListes)
        notifyDataSetChanged()
    }
}