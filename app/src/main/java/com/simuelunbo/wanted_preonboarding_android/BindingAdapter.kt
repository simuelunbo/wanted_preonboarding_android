package com.simuelunbo.wanted_preonboarding_android

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.simuelunbo.wanted_preonboarding_android.util.toTimeElapsed

object BindingAdapter {
    @JvmStatic
    @BindingAdapter("image")
    fun setThumbnailImage(view: ImageView, url: String) {
        Glide.with(view)
            .load(url)
            .placeholder(R.color.gray)
            .into(view)
    }

    @JvmStatic
    @BindingAdapter("elapsed")
    fun setElapsed(view: TextView, time: String){
        view.text = time.toTimeElapsed()
    }
}