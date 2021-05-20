package com.tetamatrix.onepiecefruits.Model

import android.graphics.Bitmap

class Fruit(
    var fruitImage: Bitmap,
    var fruitUserImage:String,
    var fruitName: String,
    var fruitType: String,
    var fruitUser: ArrayList<String>,
    var fruitTier:String,
    var fruitRarity:String,
    var fruitDescr:String
) {
}