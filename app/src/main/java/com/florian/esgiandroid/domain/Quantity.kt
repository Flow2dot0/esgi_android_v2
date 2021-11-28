package com.florian.esgiandroid.domain

import com.florian.esgiandroid.R


interface Quantity {
    val value: Double


    fun getColor(): Int
    fun getText(): Int
}

class FatsQuantity(
    override val value: Double,

    ) : Quantity {

    override fun getColor(): Int {
        if (value < 3) return R.color.nutrient_level_low
        if (value in 3.0..20.0) return R.color.nutrient_level_moderate
        return R.color.nutrient_level_high
    }

    override fun getText(): Int {
        if (value < 3) return R.string.nutrients_low
        if (value in 3.0..20.0) return R.string.nutrients_moderate
        return R.string.nutrients_high
    }

}


class SaturedFatsQuantity(
    override val value: Double,

    ) : Quantity {

    override fun getColor(): Int {
        if (value < 1.5) return R.color.nutrient_level_low
        if (value in 1.5..5.00) return R.color.nutrient_level_moderate
        return R.color.nutrient_level_high
    }

    override fun getText(): Int {
        if (value < 1.5) return R.string.nutrients_low
        if (value in 1.5..5.00) return R.string.nutrients_moderate
        return R.string.nutrients_high
    }

}

class SugarsQuantity(
    override val value: Double,

    ) : Quantity {

    override fun getColor(): Int {
        if (value < 5) return R.color.nutrient_level_low
        if (value in 5.0..12.5) return R.color.nutrient_level_moderate
        return R.color.nutrient_level_high
    }

    override fun getText(): Int {
        if (value < 5) return R.string.nutrients_low
        if (value in 5.0..12.5) return R.string.nutrients_moderate
        return R.string.nutrients_high
    }

}

class SaltQuantity(
    override val value: Double,

    ) : Quantity {

    override fun getColor(): Int {
        if (value < 0.3) return R.color.nutrient_level_low
        if (value in 0.3..1.5) return R.color.nutrient_level_moderate
        return R.color.nutrient_level_high
    }

    override fun getText(): Int {
        if (value < 0.3) return R.string.nutrients_low
        if (value in 0.3..1.5) return R.string.nutrients_moderate
        return R.string.nutrients_high
    }
}

