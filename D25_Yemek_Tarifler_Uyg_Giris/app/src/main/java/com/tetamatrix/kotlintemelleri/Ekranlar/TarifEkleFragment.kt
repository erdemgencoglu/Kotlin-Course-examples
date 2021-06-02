package com.tetamatrix.kotlintemelleri.Ekranlar

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
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
import androidx.navigation.Navigation
import com.google.android.material.snackbar.Snackbar
import com.tetamatrix.kotlintemelleri.R
import com.tetamatrix.kotlintemelleri.databinding.FragmentTarifDetayBinding
import com.tetamatrix.kotlintemelleri.databinding.FragmentTarifEkleBinding
import java.io.ByteArrayOutputStream
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
            gorselSec(it)
        }
        binding.tarifEkleButton.setOnClickListener {
            tarifEkleBtn(it)
        } //GELEN ARGUMANLAR VARMI
        arguments?.let {
            var gelenBilgi = TarifEkleFragmentArgs.fromBundle(it).bilgi
            if (gelenBilgi.equals("menudengeldim")) { //yeni bir yemek eklemeye geldi
                binding.editTextTarifAdi.setText("")
                binding.editTextMalzemeListesi.setText("")
                binding.tarifEkleButton.visibility = View.VISIBLE
                val defaultSecimImage = BitmapFactory.decodeResource(context?.resources, R.drawable.image_placeholder)
                binding.buttonTarifResmiEkle.setImageBitmap(defaultSecimImage)
            } else { //oluşturulan yemek gösterilecek
                //binding.buttonTarifResmiEkle.isEnabled = false
                val secilenId = TarifEkleFragmentArgs.fromBundle(it).id
                context?.let {
                    try {
                        val sqlLiteDatabase = it.openOrCreateDatabase("TARIFLER", Context.MODE_PRIVATE, null)
                        val cursor = sqlLiteDatabase.rawQuery("SELECT * FROM Tarif WHERE id=?", arrayOf(secilenId.toString()))
                        val tarifAdiIndex = cursor.getColumnIndex("TarifIsmi")
                        val tarifIcerikIndex = cursor.getColumnIndex("TarifIcerik")
                        val tarifBlobIndex = cursor.getColumnIndex("TarifImage")
                        while (cursor.moveToNext()) {
                            binding.editTextTarifAdi.setText(cursor.getString(tarifAdiIndex))
                            binding.editTextMalzemeListesi.setText(cursor.getString(tarifIcerikIndex))
                            val byteArray = cursor.getBlob(tarifBlobIndex)
                            val bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size)
                            binding.buttonTarifResmiEkle.setImageBitmap(bitmap)
                        }
                        cursor.close()
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            }
        }
    }

    //Tarif ekle Galeryden image Seçim
    private fun gorselSec(view: View) { //activity varmı yokmu
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
    private fun tarifEkleBtn(view: View) {
        val yemekIsmi = binding.editTextTarifAdi.text.toString();
        val tarifIcerigi = binding.editTextMalzemeListesi.text.toString();
        if (secilenBitmap != null) {
            val compressedBitmap = bitmapSikistir(secilenBitmap!!, 300) //bytArray çevirme işlemleri
            val outputStream = ByteArrayOutputStream()
            compressedBitmap.compress(Bitmap.CompressFormat.PNG, 50, outputStream)
            val bytArray = outputStream.toByteArray() // //SQLite'e işlemi
            try {
                context?.let {
                    val sqlLiteDatabase = it.openOrCreateDatabase("TARIFLER", Context.MODE_PRIVATE, null)
                    sqlLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS Tarif (id INTEGER PRIMARY KEY,TarifIsmi VARCHAR,TarifIcerik VARCHAR,TarifImage BLOB)")
                    val sql = "INSERT INTO Tarif (TarifIsmi,TarifIcerik,TarifImage) VALUES (?,?,?)"
                    val statement = sqlLiteDatabase.compileStatement(sql)
                    statement.bindString(1, yemekIsmi)
                    statement.bindString(2, tarifIcerigi)
                    statement.bindBlob(3, bytArray)
                    statement.execute()
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
            val action = TarifEkleFragmentDirections.actionTarifEkleFragmentToTariflerFragment()
            Navigation.findNavController(view).navigate(action)
        }
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
                    if (secilenGorsel != null) { //telefon versiyon kontrolü
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

    //Verilen bitmapı oransal olarak sıkıstırma fonksiyonu (Görsel küçültme)
    fun bitmapSikistir(secilenBitmap: Bitmap, maximumBoyut: Int): Bitmap {
        var width = secilenBitmap.width
        var height = secilenBitmap.height
        val bitmapOrani: Double = width.toDouble() / height.toDouble()
        if (bitmapOrani > 1) { //görsel yatay
            width = maximumBoyut
            val kisaltilmisHeight = width / bitmapOrani
            height = kisaltilmisHeight.toInt()
        } else { //görsel dikey
            height = maximumBoyut
            val kisaltilmisWidth = height * bitmapOrani
            width = kisaltilmisWidth.toInt()
        }
        return Bitmap.createScaledBitmap(secilenBitmap, width, height, true)
    }
}