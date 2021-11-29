package com.florian.esgiandroid.application

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.florian.esgiandroid.R
import com.florian.esgiandroid.presentation.organisms.ProductAdapter

class ProductsApplication private constructor(): ApplicationEngine{
    companion object {
        val INSTANCE = ProductsApplication()
    }

    override fun attachToRecyclerView(adapter : ProductAdapter, inflater: LayoutInflater, container: ViewGroup?,
                                      savedInstanceState: Bundle?) : View {
        val v = inflater.inflate(R.layout.fragment_products, container, false)
        val recyclerView = v.findViewById<RecyclerView>(R.id.products_rv)
        recyclerView.layoutManager = LinearLayoutManager(v.context)
        recyclerView.adapter = adapter
        return v
    }
}