package com.tetamatrix.besinlerkitabi.ViewModel

import android.app.Application
import android.widget.ImageView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tetamatrix.besinlerkitabi.Helper.RoomService.BesinDatabase
import com.tetamatrix.besinlerkitabi.Model.Besin
import kotlinx.coroutines.launch

class BesinDetayFragmentViewModel(application: Application) : BaseViewModel(application) {

    val besinLiveData = MutableLiveData<Besin>()


    fun roomVerisiniAll(uuid: Int) {
        launch {
            val dao = BesinDatabase(getApplication()).besinDao()
            val besin = dao.getBesin(uuid)
            besinLiveData.value = besin
        }
    }
}