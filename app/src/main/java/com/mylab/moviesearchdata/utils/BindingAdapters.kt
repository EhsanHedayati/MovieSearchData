package com.mylab.moviesearchdata.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.mylab.moviesearchdata.R




@BindingAdapter("ImageUrl")
        fun ImageView.setMyImageUrl(url: String) {

            Glide.with(context)
                .load(url)
                .placeholder(R.drawable.progress_animation)
                .centerCrop()
                .error(R.drawable.try_later)
                .into(this)

        }












