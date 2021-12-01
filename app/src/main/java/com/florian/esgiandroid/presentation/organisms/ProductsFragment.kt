package com.florian.esgiandroid.presentation.organisms

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.florian.esgiandroid.R
import com.florian.esgiandroid.domain.DefaultProduct

class ProductsFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return attachToRecyclerView(ProductAdapter(arrayOf(DefaultProduct.dummy(), DefaultProduct.dummy2(), DefaultProduct.dummy(), DefaultProduct.dummy2(), DefaultProduct.dummy3(), DefaultProduct.dummy2(), DefaultProduct.dummy(), DefaultProduct.dummy2())), inflater, container, savedInstanceState)
    }

    private fun attachToRecyclerView(adapter : ProductAdapter, inflater: LayoutInflater, container: ViewGroup?,
                                     savedInstanceState: Bundle?) : View {
        val v = inflater.inflate(R.layout.fragment_products, container, false)
        val recyclerView = v.findViewById<RecyclerView>(R.id.products_rv)
        recyclerView.layoutManager = LinearLayoutManager(v.context)
        recyclerView.adapter = adapter
        return v
    }

}