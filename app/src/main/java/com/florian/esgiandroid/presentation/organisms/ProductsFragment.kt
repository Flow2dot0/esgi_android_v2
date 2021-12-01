package com.florian.esgiandroid.presentation.organisms

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.florian.esgiandroid.R
import com.florian.esgiandroid.databinding.MainActivityBinding
import com.florian.esgiandroid.domain.DefaultProduct
import com.google.android.play.core.internal.t

class ProductsFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val myView = attachToRecyclerView(ProductAdapter(arrayOf(DefaultProduct.dummy(), DefaultProduct.dummy2(), DefaultProduct.dummy(), DefaultProduct.dummy2(), DefaultProduct.dummy3(), DefaultProduct.dummy2(), DefaultProduct.dummy(), DefaultProduct.dummy2())), inflater, container, savedInstanceState)
        onClickListener(myView)
        return myView
    }

    private fun attachToRecyclerView(adapter : ProductAdapter, inflater: LayoutInflater, container: ViewGroup?,
                                     savedInstanceState: Bundle?) : View {
        val v = inflater.inflate(R.layout.fragment_products, container, false)
        val recyclerView = v.findViewById<RecyclerView>(R.id.products_rv)
        recyclerView.layoutManager = LinearLayoutManager(v.context)
        recyclerView.adapter = adapter
        return v
    }

    private fun onClickListener(view : View) {
        val button = view.findViewById<Button>(R.id.products_start_scan)
        button.setOnClickListener {
            // TODO : Intent - 3 - 1
        }
    }

}