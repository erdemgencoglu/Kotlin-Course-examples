package com.tetamatrix.besinlerkitabi.ViewModel

import android.widget.ImageView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tetamatrix.besinlerkitabi.Model.Besin

class BesinDetayFragmentViewModel : ViewModel() {

    val besinLiveData = MutableLiveData<Besin>()


    fun fetchRoomData() {
        val muz = Besin("Muz", "200", "5", "50", "2", "")

        besinLiveData.value = muz
    }
}