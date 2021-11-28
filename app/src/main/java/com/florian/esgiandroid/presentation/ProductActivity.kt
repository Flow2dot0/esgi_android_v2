package com.florian.esgiandroid.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.florian.esgiandroid.R
import com.florian.esgiandroid.domain.DefaultProduct
import com.squareup.picasso.Picasso

class ProductActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        val product = DefaultProduct.dummy()
        val posterView = findViewById<ImageView>(R.id.posterView);
        Picasso.get()
            .load(product.imageUrl)
            .placeholder(R.drawable.petitspoidscarottes)
            .error(R.drawable.petitspoidscarottes)
            .into(posterView)
        findViewById<TextView>(R.id.title).text = product.name
        findViewById<TextView>(R.id.brand).text = product.brand
        setSpannableTextViewBold(makeTextView(R.id.barcode), R.string.barcode, product.barcode.toString())
        setSpannableTextViewBold(makeTextView(R.id.quantity), R.string.quantity, product.toString())
        setSpannableTextViewBold(makeTextView(R.id.sold), R.string.sold, product.countries.formatItemsFromList())
        setSpannableTextViewBold(makeTextView(R.id.ingredients), R.string.ingredients, product.ingredients.formatItemsFromList())
        setSpannableTextViewBold(makeTextView(R.id.allergenes), R.string.allergenes, product.allergenes.formatItemsFromList())
        setSpannableTextViewBold(makeTextView(R.id.additives), R.string.additives, product.additives.formatItemsFromList())

    }

    private fun makeTextView(rId : Int) : TextView = findViewById<TextView>(rId)

    private fun setSpannableTextViewBold(textView: TextView, rString : Int, args : String){
        textView.setSpannableTextBold(getString(rString, args))
    }
}

