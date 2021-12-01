package com.florian.esgiandroid.domain

import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.florian.esgiandroid.R
import com.squareup.picasso.Picasso

interface ImageLoader {
    fun loadInto(imageUrl : String, placeholder: Int = R.drawable.petitspoidscarottes, replacementOnError : Int = R.drawable.petitspoidscarottes, destination : ImageView)

}

class PicassoImageLoader : ImageLoader {

    override fun loadInto(
        imageUrl: String,
        placeholder: Int,
        replacementOnError: Int,
        destination: ImageView
    ) : Unit {
        Picasso.get()
            .load(imageUrl)
            .placeholder(placeholder)
            .error(replacementOnError)
            .into(destination)
    }
}