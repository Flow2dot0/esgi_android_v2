package com.florian.esgiandroid.presentation.organisms

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import com.florian.esgiandroid.R
import com.florian.esgiandroid.application.SharedViewModel
import com.florian.esgiandroid.domain.DefaultProduct
import com.florian.esgiandroid.presentation.formatItemsFromList
import com.florian.esgiandroid.presentation.makeTextView
import com.florian.esgiandroid.presentation.setSpannableTextBold
import com.squareup.picasso.Picasso

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ProductDetailsSummaryFragment : Fragment() {
    private val model : SharedViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_product_details_summary, container, false)
        val product = model.product
        val posterView = v.findViewById<ImageView>(R.id.posterView);
        Picasso.get()
            .load(product!!.imageUrl)
            .placeholder(R.drawable.petitspoidscarottes)
            .error(R.drawable.petitspoidscarottes)
            .into(posterView)
        v.findViewById<TextView>(R.id.title).text = product.name
        v.findViewById<TextView>(R.id.brand).text = product.brand
        setSpannableTextViewBold(makeTextView(v, R.id.barcode), R.string.barcode, product.barcode.toString())
        setSpannableTextViewBold(makeTextView(v, R.id.quantity), R.string.quantity, product.quantity)
        setSpannableTextViewBold(makeTextView(v, R.id.sold), R.string.sold, product.countries.formatItemsFromList())
        setSpannableTextViewBold(makeTextView(v, R.id.ingredients), R.string.ingredients, product.ingredients.formatItemsFromList())
        setSpannableTextViewBold(makeTextView(v, R.id.allergenes), R.string.allergenes, product.allergenes.formatItemsFromList())
        setSpannableTextViewBold(makeTextView(v, R.id.additives), R.string.additives, product.additives.formatItemsFromList())
        return v
    }

    private fun setSpannableTextViewBold(textView: TextView, rString : Int, args : String){
        textView.setSpannableTextBold(getString(rString, args))
    }
}