package com.florian.esgiandroid.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.florian.esgiandroid.R
import com.florian.esgiandroid.domain.DefaultProduct
import com.florian.esgiandroid.domain.NutritionsFactsItem

class NutrientsInfosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nutrients_infos)

        val product = DefaultProduct.dummy()

        findViewById<TextView>(R.id.c2_r2).text = product.nutritionFacts.energy.format()
        findViewById<TextView>(R.id.c2_r3).text = product.nutritionFacts.fats.format()
        findViewById<TextView>(R.id.c2_r4).text = product.nutritionFacts.saturedFats.format()
        findViewById<TextView>(R.id.c2_r5).text = product.nutritionFacts.glucids.format()
        findViewById<TextView>(R.id.c2_r6).text = product.nutritionFacts.sugars.format()
        findViewById<TextView>(R.id.c2_r7).text = product.nutritionFacts.fibers.format()
        findViewById<TextView>(R.id.c2_r8).text = product.nutritionFacts.proteins.format()
        findViewById<TextView>(R.id.c2_r9).text = product.nutritionFacts.salt.format()
        findViewById<TextView>(R.id.c2_r10).text = product.nutritionFacts.sodium.format()
    }
}
