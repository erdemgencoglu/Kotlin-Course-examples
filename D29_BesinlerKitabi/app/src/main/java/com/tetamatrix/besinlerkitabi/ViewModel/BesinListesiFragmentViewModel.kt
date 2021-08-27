package com.tetamatrix.besinlerkitabi.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tetamatrix.besinlerkitabi.Model.Besin

class BesinListesiFragmentViewModel : ViewModel() {

    val besinler = MutableLiveData<ArrayList<Besin>>()//RecyclerView için listeyi temsil eder
    val besinHataMesajı = MutableLiveData<Boolean>()//hata mesajı alınıp alınmadığı
    val besinYukleniyor = MutableLiveData<Boolean>()//progressbarın gösterilip gösterilmeyeceği

    //uzaktan gelen veriler işleme
    fun refleshdata() {
        val muz = Besin("Muz", "200", "5", "50", "2", "")
        val cilek = Besin("Çilek", "300", "2", "90", "3", "")
        val elma = Besin("Elma", "100", "8", "64", "1", "")

        val besinListesi: ArrayList<Besin> = ArrayList()
        besinListesi.add(muz)
        besinListesi.add(cilek)
        besinListesi.add(elma)

        besinler.value = besinListesi
        besinHataMesajı.value = false
        besinYukleniyor.value = false

    }

}