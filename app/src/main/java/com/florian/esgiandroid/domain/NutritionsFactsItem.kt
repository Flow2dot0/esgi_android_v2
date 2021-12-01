package com.florian.esgiandroid.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

interface NutritionsFactsItem {
    val unit : String
    val quantityPerPortion : Double?
    val quantityPer100g : Double
}

@Parcelize
data class DefaultNutritionsFactsItem(
    override val unit: String,
    override val quantityPerPortion: Double?,
    override val quantityPer100g: Double
) : NutritionsFactsItem, Parcelable {

    companion object {
        fun from(nutritionsFactsItem: NutritionsFactsItem) : DefaultNutritionsFactsItem {
            return DefaultNutritionsFactsItem(nutritionsFactsItem.unit, nutritionsFactsItem.quantityPerPortion, nutritionsFactsItem.quantityPer100g)
        }

    }
}