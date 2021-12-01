package com.florian.esgiandroid.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

interface NutritionFacts {
    val energy : NutritionsFactsItem
    val fats : NutritionsFactsItem
    val saturedFats : NutritionsFactsItem
    val glucids : NutritionsFactsItem
    val sugars : NutritionsFactsItem
    val fibers : NutritionsFactsItem
    val proteins : NutritionsFactsItem
    val salt : NutritionsFactsItem
    val sodium : NutritionsFactsItem
    val calories : NutritionsFactsItem
}

@Parcelize
data class DefaultNutritionFacts(
    override val energy: @RawValue NutritionsFactsItem,
    override val fats: @RawValue NutritionsFactsItem,
    override val saturedFats: @RawValue NutritionsFactsItem,
    override val glucids: @RawValue NutritionsFactsItem,
    override val sugars: @RawValue NutritionsFactsItem,
    override val fibers: @RawValue NutritionsFactsItem,
    override val proteins: @RawValue NutritionsFactsItem,
    override val salt: @RawValue NutritionsFactsItem,
    override val sodium: @RawValue NutritionsFactsItem,
    override val calories: @RawValue NutritionsFactsItem
) : NutritionFacts, Parcelable {

    companion object {
        fun dummy() : NutritionFacts {
            return DefaultNutritionFacts(
                DefaultNutritionsFactsItem(
                    "kj",
                    null,
                    293.00,
                ),
                DefaultNutritionsFactsItem(
                    "g",
                    null,
                    0.8,
                ),
                DefaultNutritionsFactsItem(
                    "g",
                    null,
                    0.1,
                ),
                DefaultNutritionsFactsItem(
                    "g",
                    null,
                    8.4,
                ),
                DefaultNutritionsFactsItem(
                    "g",
                    null,
                    5.2,
                ),
                DefaultNutritionsFactsItem(
                    "g",
                    null,
                    5.2,
                ),
                DefaultNutritionsFactsItem(
                    "g",
                    null,
                    4.8,
                ),
                DefaultNutritionsFactsItem(
                    "g",
                    null,
                    0.75,
                ),
                DefaultNutritionsFactsItem(
                    "g",
                    null,
                    0.295,
                ),
                DefaultNutritionsFactsItem(
                    "kCal",
                    null,
                    234.00,
                ),
            )
        }

        fun from(nutritionFacts: NutritionFacts) : DefaultNutritionFacts {
            return DefaultNutritionFacts(
                DefaultNutritionsFactsItem(
                    nutritionFacts.energy.unit,
                    nutritionFacts.energy.quantityPerPortion,
                    nutritionFacts.energy.quantityPer100g,
                ),
                DefaultNutritionsFactsItem(
                    nutritionFacts.fats.unit,
                    nutritionFacts.fats.quantityPerPortion,
                    nutritionFacts.fats.quantityPer100g,
                ),
                DefaultNutritionsFactsItem(
                    nutritionFacts.saturedFats.unit,
                    nutritionFacts.saturedFats.quantityPerPortion,
                    nutritionFacts.saturedFats.quantityPer100g,
                ),
                DefaultNutritionsFactsItem(
                    nutritionFacts.glucids.unit,
                    nutritionFacts.glucids.quantityPerPortion,
                    nutritionFacts.glucids.quantityPer100g,
                ),
                DefaultNutritionsFactsItem(
                    nutritionFacts.sugars.unit,
                    nutritionFacts.sugars.quantityPerPortion,
                    nutritionFacts.sugars.quantityPer100g,
                ),
                DefaultNutritionsFactsItem(
                    nutritionFacts.fibers.unit,
                    nutritionFacts.fibers.quantityPerPortion,
                    nutritionFacts.fibers.quantityPer100g,
                ),
                DefaultNutritionsFactsItem(
                    nutritionFacts.proteins.unit,
                    nutritionFacts.proteins.quantityPerPortion,
                    nutritionFacts.proteins.quantityPer100g,
                ),
                DefaultNutritionsFactsItem(
                    nutritionFacts.salt.unit,
                    nutritionFacts.salt.quantityPerPortion,
                    nutritionFacts.salt.quantityPer100g,
                ),
                DefaultNutritionsFactsItem(
                    nutritionFacts.sodium.unit,
                    nutritionFacts.sodium.quantityPerPortion,
                    nutritionFacts.sodium.quantityPer100g,
                ),
                DefaultNutritionsFactsItem(
                    nutritionFacts.calories.unit,
                    nutritionFacts.calories.quantityPerPortion,
                    nutritionFacts.calories.quantityPer100g,
                ),
            )
        }
    }
}