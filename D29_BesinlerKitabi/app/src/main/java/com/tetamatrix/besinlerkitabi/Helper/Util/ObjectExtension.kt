package com.tetamatrix.besinlerkitabi.helper.util

import android.content.Context
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.tetamatrix.besinlerkitabi.R

//Androidin Imageview nesnesine glide extension yapma
fun ImageView.gorselIndir(url: String?, placeholder: CircularProgressDrawable) {
    val options = RequestOptions().placeholder(placeholder).error(R.mipmap.ic_launcher)
    Glide.with(context).setDefaultRequestOptions(options).load(url).centerCrop().into(this);
}

//swipe reflesh layoutun progress circle kismi
fun placeholderYap(context: Context): CircularProgressDrawable {
    return CircularProgressDrawable(context).apply {
        strokeWidth = 8f
        centerRadius = 40f
        start()
    }
}

//Databinding için resim nesnesi için
@BindingAdapter("android:downloadImage")
fun downloadImage(view: ImageView, url: String?) {
    view.gorselIndir(url, placeholderYap(view.context))
}