package com.florian.esgiandroid.domain

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue
import java.net.URL
import kotlin.random.Random

interface Product {
    val name: String
    val brand: String
    val barcode: Long
    val nutriscore: String
    val imageUrl: String
    val quantity: String
    val countries: List<String>
    val ingredients: List<String>
    val allergenes: List<String>
    val additives: List<String>
    val nutritionFacts : NutritionFacts

    fun updateBarcode(barcode: Long) : DefaultProduct
}


@Parcelize
data class DefaultProduct(
    override val name: String,
    override val brand: String,
    override val barcode: Long,
    override val nutriscore: String,
    override val imageUrl: String,
    override val quantity: String,
    override val countries: List<String>,
    override val ingredients: List<String>,
    override val allergenes: List<String>,
    override val additives: List<String>, override val nutritionFacts: @RawValue NutritionFacts,
) : Product, Parcelable {

    override fun updateBarcode(barcode: Long) : DefaultProduct {
        return DefaultProduct(
            this.name,
            this.brand,
            barcode,
            this.nutriscore,
            this.imageUrl,
            this.quantity,
            this.countries,
            this.ingredients,
            this.allergenes,
            this.additives,
            DefaultNutritionFacts.from(this.nutritionFacts)
        )
    }

    companion object {
        fun dummy(): Product {
            return DefaultProduct(
                "Petits pois et carottes",
                "Cassegrain",
                3083680085304,
                "nutriscore_e",
                "https://static.openfoodfacts.org/images/products/308/368/008/5304/front_fr.7.400.jpg",
                "400 g (280 g net égoutté)",
                listOf("France", "Japon", "Suisse"),
                listOf("Petits pois 66%", "eau", "garniture 2,8% (salade, oignon grelot)", "sucre", "sel", "arôme naturel"),
                listOf("Aucune"),
                listOf("Aucun"),
                DefaultNutritionFacts.dummy()
            )
        }

        fun dummy2(): Product {
            return DefaultProduct(
                "Cassoulet",
                "Cassegrain",
                3083680085304,
                "nutriscore_e",
                "https://media.istockphoto.com/photos/beans-soup-rioja-picture-id475841792?k=20&m=475841792&s=612x612&w=0&h=AeB_RfeD3YeP2aLat_8tRL4BmI3OB1sAPSm_eo0dGXU=",
                "400 g (280 g net égoutté)",
                listOf("France", "Japon", "Suisse"),
                listOf("Petits pois 66%", "eau", "garniture 2,8% (salade, oignon grelot)", "sucre", "sel", "arôme naturel"),
                listOf("Aucune"),
                listOf("Aucun"),
                DefaultNutritionFacts.dummy()
            )
        }

        fun dummy3(): Product {
            return DefaultProduct(
                "Ratatouille",
                "Cassegrain",
                3083680085304,
                "nutriscore_e",
                "https://www.kenwoodworld.com/Global/recipes/Recipe%20Images/Chef%20Attachments/Saucy-BAKED-ratatouille-hero.jpg",
                "400 g (280 g net égoutté)",
                listOf("France", "Japon", "Suisse"),
                listOf("Petits pois 66%", "eau", "garniture 2,8% (salade, oignon grelot)", "sucre", "sel", "arôme naturel"),
                listOf("Aucune"),
                listOf("Aucun"),
                DefaultNutritionFacts.dummy()
            )
        }

        fun from(product: Product) : DefaultProduct {
            return DefaultProduct(
                product.name,
                product.brand,
                product.barcode,
                product.nutriscore,
                product.imageUrl,
                product.quantity,
                product.countries,
                product.ingredients,
                product.allergenes,
                product.additives,
                DefaultNutritionFacts.from(product.nutritionFacts)
            )
        }

        fun generateDummy() : Product{
            val l = listOf<Product>(dummy(), dummy2(), dummy3())
            val rand = Random(0).nextInt(2)
            return l[rand]
        }

    }
}


fun DefaultProduct.toImage(): Bitmap {
    return BitmapFactory.decodeStream(URL(this.imageUrl).openConnection().getInputStream())
}
