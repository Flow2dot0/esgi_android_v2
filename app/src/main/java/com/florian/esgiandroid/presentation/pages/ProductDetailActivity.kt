package com.florian.esgiandroid.presentation.pages

import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.core.graphics.drawable.DrawableCompat
import com.florian.esgiandroid.R
import com.florian.esgiandroid.domain.*
import com.florian.esgiandroid.presentation.toDecimal2

class ProductDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        val product = DefaultProduct.dummy()

        buildTile(
            R.id.circle_level,
            R.id.tile_fats_qty,
            R.id.tile_fats_content,
            R.string.nutrients_fats,
            product.nutritionFacts.fats.quantityPer100g.toDecimal2(),
            FatsQuantity(product.nutritionFacts.fats.quantityPer100g),
        )
        buildTile(
            R.id.circle_level2,
            R.id.tile_satured_fats_qty,

            R.id.tile_satured_fats_content,
            R.string.nutrients_satured_fats,
            product.nutritionFacts.saturedFats.quantityPer100g.toDecimal2(),

            SaturedFatsQuantity(product.nutritionFacts.saturedFats.quantityPer100g)
        )
        buildTile(
            R.id.circle_level3,
            R.id.tile_sugars_qty,

            R.id.tile_sugars_content,
            R.string.nutrients_sugars,
            product.nutritionFacts.sugars.quantityPer100g.toDecimal2(),

            SugarsQuantity(product.nutritionFacts.sugars.quantityPer100g)
        )
        buildTile(
            R.id.circle_level4,
            R.id.tile_salt_qty,

            R.id.tile_salt_content,
            R.string.nutrients_salt,
            product.nutritionFacts.salt.quantityPer100g.toDecimal2(),

            SaltQuantity(product.nutritionFacts.salt.quantityPer100g)
        )

    }

    private fun buildTile(
        circleId: Int,
        textId: Int,
        subTextId: Int,
        rString: Int,
        args: String,
        quantity: Quantity
    ): Unit {
        DrawableCompat.setTintList(
            findViewById<ImageView>(circleId).drawable,
            ColorStateList.valueOf(quantity.getColor())
        )
        setTextViewBold(findViewById(textId), rString, args)
        findViewById<TextView>(subTextId).setText(quantity.getText())
    }

    private fun makeTextView(rId: Int): TextView = findViewById<TextView>(rId)

    private fun setTextViewBold(textView: TextView, rString: Int, args: String) {
        textView.text = getString(rString, args)
    }
}


