package com.florian.esgiandroid.presentation.organisms

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.florian.esgiandroid.R
import com.florian.esgiandroid.application.SharedViewModel
import com.florian.esgiandroid.domain.DefaultProduct
import com.google.android.material.bottomnavigation.BottomNavigationView


class ProductDetailsFragment : Fragment(R.layout.fragment_product_details) {
    private val model : SharedViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            val param1 = it.getParcelable<DefaultProduct>("product")
            model.set(param1!!)
            println(model.product)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_product_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navHost = childFragmentManager.findFragmentById(R.id.product_details_nav_host) as NavHostFragment
        NavigationUI
            .setupWithNavController(view.findViewById<BottomNavigationView>(R.id.product_details_bottom_nav), navHost.navController)

    }

}