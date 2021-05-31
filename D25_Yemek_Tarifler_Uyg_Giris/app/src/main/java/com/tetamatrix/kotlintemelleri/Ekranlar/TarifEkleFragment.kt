package com.tetamatrix.kotlintemelleri.Ekranlar

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import com.tetamatrix.kotlintemelleri.R
import com.tetamatrix.kotlintemelleri.databinding.FragmentTarifDetayBinding
import com.tetamatrix.kotlintemelleri.databinding.FragmentTarifEkleBinding
import java.lang.Exception
import java.util.jar.Manifest


class TarifEkleFragment : Fragment() {
    private var _binding: FragmentTarifEkleBinding? = null
    private val binding get() = _binding!!
    private var secilenGorsel: Uri? = null
    private var secilenBitmap: Bitmap? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? { // Inflate the layout for this fragment
        _binding = FragmentTarifEkleBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState) //Fragmentlara özel tanımlama yapılmalıdır
        //Arayüzden fonksiyon atandığında
        binding.buttonTarifResmiEkle.setOnClickListener {
            GorselSec(it)
        }
        binding.tarifEkleButton.setOnClickListener {
            TarifEkleBtn(it)
        }
    }

    //Tarif ekle Galeryden image Seçim
    fun GorselSec(view: View) { //activity varmı yokmu
        activity?.let { //activity,activity. şeklinde çağrılablir ama ContextCompatten çağırırsak çmceki apiler için uğraşmayız
            if (ContextCompat.checkSelfPermission(it.applicationContext, android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) { //izin verilmedi
                requestPermissions(arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE), 1) //code bu izin için yazdığımız code kullanıcı tarafında verilir (İlerde kolaylık sağlasın diye)
            } else { //izin verilmiş
                val galeryIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                startActivityForResult(galeryIntent, 2)
            }
        }

    }

    //Tarif ekleme butonu
    fun TarifEkleBtn(view: View) {
    }

    //Permissionların sonuçlarını kontrol etme
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if (requestCode == 1) {
            if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                val galeryIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                startActivityForResult(galeryIntent, 2)
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    //Activity sonuçları
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 2 && resultCode == Activity.RESULT_OK && data != null) { //secilen görselin uriyi alındı
            secilenGorsel = data.data
            try {
                context?.let {
                    if (secilenGorsel != null) {
                        //telefon versiyon kontrolü
                        if (Build.VERSION.SDK_INT >= 28) {
                            val source = ImageDecoder.createSource(it.contentResolver, secilenGorsel!!)
                            secilenBitmap = ImageDecoder.decodeBitmap(source)
                            binding.buttonTarifResmiEkle.setImageBitmap(secilenBitmap);
                        } else {
                            secilenBitmap = MediaStore.Images.Media.getBitmap(it.contentResolver, secilenGorsel)
                            binding.buttonTarifResmiEkle.setImageBitmap(secilenBitmap);
                        }
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}