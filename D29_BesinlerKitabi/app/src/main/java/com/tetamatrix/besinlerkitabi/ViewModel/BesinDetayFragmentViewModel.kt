package com.tetamatrix.besinlerkitabi.viewModel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.tetamatrix.besinlerkitabi.helper.roomService.BesinDatabase
import com.tetamatrix.besinlerkitabi.model.Besin
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