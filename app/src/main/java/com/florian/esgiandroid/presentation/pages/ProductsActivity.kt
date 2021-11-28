package com.florian.esgiandroid.presentation.pages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.florian.esgiandroid.R
import com.florian.esgiandroid.domain.DefaultProduct
import com.florian.esgiandroid.domain.Product
import com.florian.esgiandroid.presentation.organisms.ProductAdapter

class ProductsActivity : AppCompatActivity() {

    val adapter = ProductAdapter(arrayOf(DefaultProduct.dummy(),DefaultProduct.dummy()))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        val recyclerView = findViewById<RecyclerView>(R.id.products_rv)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

    }
}

