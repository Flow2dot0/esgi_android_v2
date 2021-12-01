package com.florian.esgiandroid.application

import androidx.lifecycle.ViewModel
import com.florian.esgiandroid.domain.Product

class SharedViewModel : ViewModel() {
    var product : Product? = null
    val products : MutableList<Product> = mutableListOf()


    fun add(item: Product) {
        products.add(item)
    }

    fun onSelect(item: Product) {
        product = item
    }


}
