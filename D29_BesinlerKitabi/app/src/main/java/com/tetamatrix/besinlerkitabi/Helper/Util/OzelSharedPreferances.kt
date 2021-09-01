package com.tetamatrix.besinlerkitabi.helper.util

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import androidx.preference.PreferenceManager

class OzelSharedPreferances {
    companion object {
        private var ZAMAN = "zaman"
        private var sharedPreferances: SharedPreferences? = null


        @Volatile
        private var instance: OzelSharedPreferances? = null
        private val lock = Any()

        operator fun invoke(context: Context): OzelSharedPreferances = instance ?: synchronized(lock) {
            instance ?: ozelSharedPreferencesYap(context).also {
                instance = it
            }
        }

        private fun ozelSharedPreferencesYap(context: Context): OzelSharedPreferances {
            sharedPreferances = PreferenceManager.getDefaultSharedPreferences(context)
            return OzelSharedPreferances()
        }
    }

    fun zamanKaydet(zaman: Long) {
        sharedPreferances?.edit(commit = true) {
            putLong(ZAMAN, zaman)
        }
    }

    fun zamanAl() = sharedPreferances?.getLong(ZAMAN, 0)
}
