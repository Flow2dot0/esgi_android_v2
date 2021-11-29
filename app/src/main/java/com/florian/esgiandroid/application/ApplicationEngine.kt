package com.florian.esgiandroid.application

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.florian.esgiandroid.presentation.organisms.ProductAdapter

interface ApplicationEngine {

    fun attachToRecyclerView(adapter : ProductAdapter, inflater: LayoutInflater, container: ViewGroup?,
                             savedInstanceState: Bundle?) : View
}