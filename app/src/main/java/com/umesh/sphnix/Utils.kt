package com.umesh.sphnix

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide

fun setImageByGlide(context: Context, url:String, imageView: ImageView) {
    Glide.with(context)
        .load(url)
        .placeholder(R.drawable.ic_launcher_background)
        .into(imageView)

}