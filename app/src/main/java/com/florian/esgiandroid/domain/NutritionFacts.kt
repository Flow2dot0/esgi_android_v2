package com.florian.esgiandroid.domain

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

class DefaultNutritionFacts(
    override val energy: NutritionsFactsItem,
    override val fats: NutritionsFactsItem,
    override val saturedFats: NutritionsFactsItem,
    override val glucids: NutritionsFactsItem,
    override val sugars: NutritionsFactsItem,
    override val fibers: NutritionsFactsItem,
    override val proteins: NutritionsFactsItem,
    override val salt: NutritionsFactsItem,
    override val sodium: NutritionsFactsItem, override val calories: NutritionsFactsItem
) : NutritionFacts{

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
    }
}