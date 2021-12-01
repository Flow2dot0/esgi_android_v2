package com.florian.esgiandroid.presentation.organisms

import android.app.Activity
import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.florian.esgiandroid.R
import com.florian.esgiandroid.application.SharedViewModel
import com.florian.esgiandroid.domain.DefaultProduct
import com.florian.esgiandroid.domain.Product


class ProductsFragment : Fragment() {
    private lateinit var myView: View
    private val model : SharedViewModel by activityViewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            val param1 = it.getString("barcode")
            val product = DefaultProduct.generateDummy()
            product.updateBarcode(param1!!.toLong())
            model.add(product)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val arr = arrayListOf<Product>()
        arr.addAll(model.products)
        myView = attachToRecyclerView(ProductAdapter(arr), inflater, container, savedInstanceState)
        myView.findViewById<Button>(R.id.fragment_empty_button).setBackgroundResource(R.drawable.elevated_rounded_button)
        onClickListener(myView)
        return myView
    }

    private fun attachToRecyclerView(adapter : ProductAdapter, inflater: LayoutInflater, container: ViewGroup?,
                                     savedInstanceState: Bundle?) : View {
        val v = inflater.inflate(com.florian.esgiandroid.R.layout.fragment_products, container, false)
        val recyclerView = v.findViewById<RecyclerView>(com.florian.esgiandroid.R.id.products_rv)
        recyclerView.layoutManager = LinearLayoutManager(v.context)
        recyclerView.adapter = adapter
        return v
    }

    private fun onClickListener(view : View) {
        val button = view.findViewById<Button>(com.florian.esgiandroid.R.id.products_start_scan)
        button.setOnClickListener {
            val intent = Intent()
            intent.action = "com.google.zxing.client.android.SCAN"
            intent.putExtra("SCAN_FORMATS", "EAN_13")
            getResult.launch(intent)
        }
    }

    private val getResult =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {
            if (it.resultCode == Activity.RESULT_OK) {
                val format = it.data?.getStringExtra("SCAN_RESULT_FORMAT")
                val res = it.data?.getStringExtra("SCAN_RESULT")
                val product = DefaultProduct.generateDummy()
                product.updateBarcode(res!!.toLong())
                model.add(product)
            }

            if (it.resultCode == Activity.RESULT_CANCELED) {
                Log.e("EmptyFragment", "Scan cancelled !")
            }
        }
}