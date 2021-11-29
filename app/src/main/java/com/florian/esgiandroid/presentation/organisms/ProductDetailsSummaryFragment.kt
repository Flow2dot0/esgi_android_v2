package com.florian.esgiandroid.presentation.organisms

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.florian.esgiandroid.R
import com.florian.esgiandroid.domain.DefaultProduct
import com.florian.esgiandroid.presentation.formatItemsFromList
import com.florian.esgiandroid.presentation.makeTextView
import com.florian.esgiandroid.presentation.setSpannableTextBold
import com.squareup.picasso.Picasso

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ProductDetailsSummaryFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_product_details_summary, container, false)
        val product = DefaultProduct.dummy()
        val posterView = v.findViewById<ImageView>(R.id.posterView);
        Picasso.get()
            .load(product.imageUrl)
            .placeholder(R.drawable.petitspoidscarottes)
            .error(R.drawable.petitspoidscarottes)
            .into(posterView)
        v.findViewById<TextView>(R.id.title).text = product.name
        v.findViewById<TextView>(R.id.brand).text = product.brand
        setSpannableTextViewBold(makeTextView(v, R.id.barcode), R.string.barcode, product.barcode.toString())
        setSpannableTextViewBold(makeTextView(v, R.id.quantity), R.string.quantity, product.toString())
        setSpannableTextViewBold(makeTextView(v, R.id.sold), R.string.sold, product.countries.formatItemsFromList())
        setSpannableTextViewBold(makeTextView(v, R.id.ingredients), R.string.ingredients, product.ingredients.formatItemsFromList())
        setSpannableTextViewBold(makeTextView(v, R.id.allergenes), R.string.allergenes, product.allergenes.formatItemsFromList())
        setSpannableTextViewBold(makeTextView(v, R.id.additives), R.string.additives, product.additives.formatItemsFromList())
        return v
    }

    private fun setSpannableTextViewBold(textView: TextView, rString : Int, args : String){
        textView.setSpannableTextBold(getString(rString, args))
    }


    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProductDetailsSummaryFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}