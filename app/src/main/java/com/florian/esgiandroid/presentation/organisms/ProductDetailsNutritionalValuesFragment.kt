package com.florian.esgiandroid.presentation.organisms

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import com.florian.esgiandroid.R
import com.florian.esgiandroid.application.SharedViewModel
import com.florian.esgiandroid.domain.DefaultProduct
import com.florian.esgiandroid.presentation.format

class ProductDetailsNutritionalValuesFragment : Fragment() {
    private val model : SharedViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(
            R.layout.fragment_product_details_nutritional_values,
            container,
            false
        )

        val product = model.product


        v.findViewById<TextView>(R.id.c2_r2).text = product!!.nutritionFacts.energy.format()
        v.findViewById<TextView>(R.id.c2_r3).text = product.nutritionFacts.fats.format()
        v.findViewById<TextView>(R.id.c2_r4).text = product.nutritionFacts.saturedFats.format()
        v.findViewById<TextView>(R.id.c2_r5).text = product.nutritionFacts.glucids.format()
        v.findViewById<TextView>(R.id.c2_r6).text = product.nutritionFacts.sugars.format()
        v.findViewById<TextView>(R.id.c2_r7).text = product.nutritionFacts.fibers.format()
        v.findViewById<TextView>(R.id.c2_r8).text = product.nutritionFacts.proteins.format()
        v.findViewById<TextView>(R.id.c2_r9).text = product.nutritionFacts.salt.format()
        v.findViewById<TextView>(R.id.c2_r10).text = product.nutritionFacts.sodium.format()

        return v
    }

}