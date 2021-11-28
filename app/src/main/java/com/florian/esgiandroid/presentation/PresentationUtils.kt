package com.florian.esgiandroid.presentation

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Typeface
import android.os.Handler
import android.os.Looper
import android.provider.Settings.Global.getString
import android.text.SpannableStringBuilder
import android.text.style.StyleSpan
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.florian.esgiandroid.domain.NutritionsFactsItem
import java.math.RoundingMode
import java.text.DecimalFormat
import java.util.concurrent.Executors

fun TextView.setSpannableTextBold(text: String, separator: String = ":") {
    val builder = SpannableStringBuilder(text)
    builder.setSpan(StyleSpan(Typeface.BOLD), 0, text.indexOf(separator) + 1, 0)
    setText(builder)
}

fun List<String>.formatItemsFromList() : String{
    return this.toString().substring(1, this.toString().length-1)
}

fun Double.toDecimal2(): String {
    val df = DecimalFormat("#.##")
    df.roundingMode = RoundingMode.CEILING
    return df.format(this)
}

fun NutritionsFactsItem.format() : StringBuilder = StringBuilder().append(this.quantityPer100g.toString()).append(" ").append(this.unit)

fun loadImage (imageView : ImageView, imageURL : String) : Unit {
    // Declaring executor to parse the URL
    val executor = Executors.newSingleThreadExecutor()

    // Once the executor parses the URL
    // and receives the image, handler will load it
    // in the ImageView
    val handler = Handler(Looper.getMainLooper())

    // Initializing the image
    var image: Bitmap? = null

    // Only for Background process (can take time depending on the Internet speed)
    executor.execute {

        // Tries to get the image and post it in the ImageView
        // with the help of Handler
        try {
            val `in` = java.net.URL(imageURL).openStream()
            image = BitmapFactory.decodeStream(`in`)

            // Only for making changes in UI
            handler.post {
                imageView.setImageBitmap(image)
            }
        }

        // If the URL doesnot point to
        // image or any other kind of failure
        catch (e: Exception) {
            e.printStackTrace()
        }
    }
}