package com.tetamatrix.myapplication

import android.Manifest
import android.app.Activity
import android.app.PendingIntent.getActivity
import android.content.Context
import android.content.pm.PackageManager
import android.location.Geocoder
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.tetamatrix.myapplication.databinding.ActivityGoogleMapsKotlinBinding
import java.util.*

class GoogleMapsKotlin : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityGoogleMapsKotlinBinding
    private lateinit var locationManager: LocationManager
    private lateinit var locationListener: LocationListener
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGoogleMapsKotlinBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

    }


    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        mMap.setOnMapLongClickListener(dinleyici)
        // Latitude ->Enlem
        // Longitude ->Boylam
        /*val ankara = LatLng(39.9035557, 32.6226817)
        mMap.addMarker(MarkerOptions().position(ankara).title("Ankara"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ankara, 15f))*/

        //casting kotlinde as ile yapılır
        locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        locationListener = object : LocationListener {
            override fun onLocationChanged(location: Location) {
                //Konum değişimi olduğunda
                mMap.clear()
                println("${location.latitude},${location.longitude}")
                val guncelkonum = LatLng(location.latitude, location.longitude)
                mMap.addMarker(MarkerOptions().position(guncelkonum).title("Yeni Konum"))
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(guncelkonum, 15f))

                val geocoder = Geocoder(this@GoogleMapsKotlin, Locale.getDefault())

                try {
                    val adressList = geocoder.getFromLocation(location.latitude, location.longitude, 1)//1 tane sonuç getir 1 den fazla sonuç getirilebilir
                    if (adressList.size > 0) {
                        println(adressList.get(0).toString())
                    }

                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
        MapsIzinIste()

    }

    //Kullanıcıdan Konum alma izni
    fun MapsIzinIste() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            //izin verilmemiş
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 1)
        } else {
            //izin verilmiş
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1, 1f, locationListener)
            //Son bilinen konumu çekme
            val sonBilinenKonum = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)//NetworkProvider dan da alınabilir durumuna göre
            if (sonBilinenKonum != null) {
                val sonBilinenLatLing = LatLng(sonBilinenKonum.latitude, sonBilinenKonum.longitude)
                mMap.addMarker(MarkerOptions().position(sonBilinenLatLing).title("Son Bilinen Konum"))
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sonBilinenLatLing, 15f))
            }
        }
    }

    //İzinlerin sonucunu dinleme
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if (requestCode == 1) {
            //Bir izin sonucu varmı
            if (grantResults.size > 0) {
                if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    //izin verilmiş
                    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1, 1f, locationListener)
                }
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    val dinleyici = GoogleMap.OnMapLongClickListener {
        mMap.clear()
        val geocoder = Geocoder(this@GoogleMapsKotlin, Locale.getDefault())
        if (it != null) {
            var adres = ""
            try {
                val adressList = geocoder.getFromLocation(it.latitude, it.longitude, 1)//1 tane sonuç getir 1 den fazla sonuç getirilebilir
                if (adressList.size > 0) {
                    adres += adressList.get(0).thoroughfare + "/" + adressList.get(0).subThoroughfare + "/" + adressList.get(0).phone
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
            mMap.addMarker(MarkerOptions().position(it).title(adres))
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(it, 15f))
        }
    }
}

