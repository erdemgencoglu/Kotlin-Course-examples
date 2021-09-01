package com.tetamatrix.besinlerkitabi.viewModel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.tetamatrix.besinlerkitabi.helper.retrofitService.BesinApiService
import com.tetamatrix.besinlerkitabi.helper.roomService.BesinDatabase
import com.tetamatrix.besinlerkitabi.helper.util.OzelSharedPreferances
import com.tetamatrix.besinlerkitabi.model.Besin
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.launch

class BesinListesiFragmentViewModel(application: Application) : BaseViewModel(application) {

    val besinler = MutableLiveData<List<Besin>>()//RecyclerView için listeyi temsil eder
    val besinHataMesajı = MutableLiveData<Boolean>()//hata mesajı alınıp alınmadığı
    val besinYukleniyor = MutableLiveData<Boolean>()//progressbarın gösterilip gösterilmeyeceği
    private val besinApiService = BesinApiService()
    private val disposable = CompositeDisposable()
    private val ozelSharedPreferances = OzelSharedPreferances(getApplication())
    private val guncellemeZamani = 10 * 60 * 1000 * 1000 * 1000L//10 dk

    //uzaktan gelen veriler işleme
    fun refleshdata() {
        val kaydedilmeZamani = ozelSharedPreferances.zamanAl()
        if (kaydedilmeZamani != null && kaydedilmeZamani != 0L && System.nanoTime() - kaydedilmeZamani < guncellemeZamani) {
            //Sqlite'tan çek
            verileriLocaldenAl()
        } else {
            verileriInternettenAl()
        }
    }

    fun refleshFromInternet() {
        verileriInternettenAl()
    }


    //IO, Default, UI thread çeşitleri
    private fun verileriInternettenAl() {
        besinYukleniyor.value = true
        disposable.add(
            besinApiService.getData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<Besin>>() {
                    override fun onSuccess(t: List<Besin>) {
                        //Success
                        //besinler.value = t
                        sqliteSakla(t)
                        Toast.makeText(getApplication(), "Besinler İnternetten alındı", Toast.LENGTH_LONG).show()
                    }

                    override fun onError(e: Throwable) {
                        //Error
                        besinHataMesajı.value = true
                        besinYukleniyor.value = false
                        e.printStackTrace()
                    }

                })
        )
    }

    private fun verileriLocaldenAl() {
        launch {
            val besinListesi = BesinDatabase(getApplication()).besinDao().getAllBesin()
            besinleriGoster(besinListesi)
            Toast.makeText(getApplication(), "Besinler Roomdan alındı", Toast.LENGTH_LONG).show()
        }
    }

    private fun besinleriGoster(besinlerListesi: List<Besin>) {
        besinler.value = besinlerListesi
        besinHataMesajı.value = false
        besinYukleniyor.value = false
    }


    private fun sqliteSakla(besinlerListesi: List<Besin>) {
        launch {
            val dao = BesinDatabase(getApplication()).besinDao()
            dao.deleteAllBesin()
            val uuidListesi = dao.insertAll(*besinlerListesi.toTypedArray())
            var i = 0
            while (i < besinlerListesi.size) {
                besinlerListesi[i].uuid = uuidListesi[i].toInt()
                i++
            }
            besinleriGoster(besinlerListesi)
        }
        ozelSharedPreferances.zamanKaydet(System.nanoTime())
    }

}