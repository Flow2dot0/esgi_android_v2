package com.florian.esgiandroid.presentation.organisms

import android.content.res.ColorStateList
import android.graphics.ColorFilter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.graphics.drawable.DrawableCompat
import androidx.fragment.app.activityViewModels
import com.florian.esgiandroid.R
import com.florian.esgiandroid.application.SharedViewModel
import com.florian.esgiandroid.domain.*
import com.florian.esgiandroid.presentation.toDecimal2

class ProductDetailsNutritionFragment : Fragment() {
    private val model : SharedViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val product = model.product

        val v = inflater.inflate(R.layout.fragment_product_details_nutrition, container, false)

        buildTile(
            R.id.circle_level,
            R.id.tile_fats_qty,
            R.id.tile_fats_content,
            R.string.nutrients_fats,
            product!!.nutritionFacts.fats.quantityPer100g.toDecimal2(),
            FatsQuantity(product.nutritionFacts.fats.quantityPer100g),
            v
        )
        buildTile(
            R.id.circle_level2,
            R.id.tile_satured_fats_qty,

            R.id.tile_satured_fats_content,
            R.string.nutrients_satured_fats,
            product.nutritionFacts.saturedFats.quantityPer100g.toDecimal2(),

            SaturedFatsQuantity(product.nutritionFacts.saturedFats.quantityPer100g),
            v
        )
        buildTile(
            R.id.circle_level3,
            R.id.tile_sugars_qty,

            R.id.tile_sugars_content,
            R.string.nutrients_sugars,
            product.nutritionFacts.sugars.quantityPer100g.toDecimal2(),

            SugarsQuantity(product.nutritionFacts.sugars.quantityPer100g),
            v
        )
        buildTile(
            R.id.circle_level4,
            R.id.tile_salt_qty,

            R.id.tile_salt_content,
            R.string.nutrients_salt,
            product.nutritionFacts.salt.quantityPer100g.toDecimal2(),

            SaltQuantity(product.nutritionFacts.salt.quantityPer100g),
            v
        )
        return v

    }

    private fun buildTile(
        circleId: Int,
        textId: Int,
        subTextId: Int,
        rString: Int,
        args: String,
        quantity: Quantity,
        view: View
    ): Unit {

        val color = quantity.getColor()
        DrawableCompat.setTintList(
            view.findViewById<ImageView>(circleId).background,
            ColorStateList.valueOf(requireContext().getColor(color))
        )
        setTextViewBold(view.findViewById(textId), rString, args)
        view.findViewById<TextView>(subTextId).setText(quantity.getText())
    }

    private fun setTextViewBold(textView: TextView, rString: Int, args: String) {
        textView.text = getString(rString, args)
    }

}