package com.florian.esgiandroid.domain

interface NutritionsFactsItem {
    val unit : String
    val quantityPerPortion : Double?
    val quantityPer100g : Double
}

data class DefaultNutritionsFactsItem(
    override val unit: String,
    override val quantityPerPortion: Double?,
    override val quantityPer100g: Double
) : NutritionsFactsItem {

    companion object {


    }
}