package com.tetamatrix.besinlerkitabi.helper.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.tetamatrix.besinlerkitabi.model.Besin
import com.tetamatrix.besinlerkitabi.R
import com.tetamatrix.besinlerkitabi.databinding.FragmentBesinListesiRcyclerviewRowBinding
import com.tetamatrix.besinlerkitabi.view.BesinListesiFragmentDirections

class RecyclerAdapterBesinListesi(val besinListesi: ArrayList<Besin>) : RecyclerView.Adapter<RecyclerAdapterBesinListesi.BesinViewHolder>(), BesinListClickListener {
    //Row binding tipindeki view layout isminde oto oluşmakta
    class BesinViewHolder(var view: FragmentBesinListesiRcyclerviewRowBinding) : RecyclerView.ViewHolder(view.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BesinViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        //val view = inflater.inflate(R.layout.fragment_besin_listesi_rcyclerview_row, parent, false)
        val view = DataBindingUtil.inflate<FragmentBesinListesiRcyclerviewRowBinding>(inflater, R.layout.fragment_besin_listesi_rcyclerview_row, parent, false)
        return BesinViewHolder(view)
    }

    override fun onBindViewHolder(holder: BesinViewHolder, position: Int) {
        /* //declare
         val besinRowImage: ImageView = holder.itemView.findViewById(R.id.imageViewBesinListesiItemBesinImage)
         val besinAdi: TextView = holder.itemView.findViewById(R.id.textViewBesinListesiItemBesinAdi)
         val besinKalori: TextView = holder.itemView.findViewById(R.id.textViewBesinListesiItemKalori)
         //setting
         besinAdi.text = besinListesi[position].isim
         besinKalori.text = besinListesi[position].kalori
         besinRowImage.gorselIndir(besinListesi[position].gorsel, placeholderYap(holder.itemView.context))

         //liste tıklama olayı
         holder.itemView.setOnClickListener {
             val action = BesinListesiFragmentDirections.actionBesinListesiFragmentToBesinDetayFragment(besinListesi[position].uuid)
             Navigation.findNavController(it).navigate(action)
         }
         */
        holder.view.besin = besinListesi[position]
        holder.view.besinListener = this
    }

    //besinlistesi size döndürme
    override fun getItemCount(): Int {
        return besinListesi.size
    }

    //Listeyi Güncelleme(Activityden yapmaktansa burada daha toplu olur)
    fun besinlistesiGuncelle(guncelBesinListes: List<Besin>) {
        besinListesi.clear()
        besinListesi.addAll(guncelBesinListes)
        notifyDataSetChanged()
    }

    //Listenin tıklanma olayı
    override fun besinOnClick(view: View) {
        val uuidText: TextView = view.findViewById(R.id.besin_uuid)
        val uuid = uuidText.text.toString().toIntOrNull()
        uuid?.let {
            val action = BesinListesiFragmentDirections.actionBesinListesiFragmentToBesinDetayFragment(it)
            Navigation.findNavController(view).navigate(action)
        }
    }
}