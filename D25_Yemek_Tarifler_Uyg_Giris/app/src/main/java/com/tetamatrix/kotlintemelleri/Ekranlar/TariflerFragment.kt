package com.tetamatrix.kotlintemelleri.Ekranlar

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.tetamatrix.kotlintemelleri.Helper.Adapters.RecyclerAdapterTarifler
import com.tetamatrix.kotlintemelleri.databinding.FragmentTariflerBinding
import java.sql.Blob

class TariflerFragment : Fragment() {
    //View binding layoutun camelcase halidir
    private var _binding: FragmentTariflerBinding? = null
    private val binding get() = _binding!!

    var tarifIsmiListesi = ArrayList<String>()
    var tarifIdListesi = ArrayList<Int>()
    var tarifImageListesi = ArrayList<ByteArray>()
    private lateinit var adapter: RecyclerAdapterTarifler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? { // Inflate the layout for this fragment
        _binding = FragmentTariflerBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = RecyclerAdapterTarifler(tarifIsmiListesi, tarifIdListesi, tarifImageListesi)
        binding.rcyclerTarifler.layoutManager = LinearLayoutManager(context)
        binding.rcyclerTarifler.adapter = adapter

        yemekTarifleriniGetir()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    //Datalari hazirlama
    fun yemekTarifleriniGetir() {
        try {
            activity?.let {
                val sqLiteDatabase = it.openOrCreateDatabase("TARIFLER", Context.MODE_PRIVATE, null)
                val cursor = sqLiteDatabase.rawQuery("SELECT * FROM Tarif", null)
                val tarifAdiIndex = cursor.getColumnIndex("TarifIsmi")
                val tarifIdIndex = cursor.getColumnIndex("id")
                val tarifBlobIndex = cursor.getColumnIndex("TarifImage")

                tarifIsmiListesi.clear()
                tarifIdListesi.clear()
                tarifImageListesi.clear()
                while (cursor.moveToNext()) {
                    tarifIsmiListesi.add(cursor.getString(tarifAdiIndex))
                    tarifIdListesi.add(cursor.getInt(tarifIdIndex))
                    tarifImageListesi.add(cursor.getBlob(tarifBlobIndex))

                }

                adapter.notifyDataSetChanged()//adapter güncelleme

                cursor.close()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}