package com.tetamatrix.besinlerkitabi.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

//@Entity(tablo ismi verilebilir)
@Entity
data class Besin(
    @ColumnInfo(name = "isim")
    @SerializedName("isim")
    var isim: String?,

    @ColumnInfo(name = "kalori")
    @SerializedName("kalori")
    var kalori: String?,

    @ColumnInfo(name = "karbonhidrad")
    @SerializedName("karbonhidrad")
    var karbonhidrad: String?,

    @ColumnInfo(name = "protein")
    @SerializedName("protein")
    var protein: String?,

    @ColumnInfo(name = "yag")
    @SerializedName("yag")
    var yag: String?,

    @ColumnInfo(name = "gorsel")
    @SerializedName("gorsel")
    var gorsel: String?,
) {
    @PrimaryKey(autoGenerate = true)
    var uuid: Int = 0
}