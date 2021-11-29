package com.florian.esgiandroid.presentation.organisms

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.florian.esgiandroid.R
import com.florian.esgiandroid.domain.DefaultProduct
import com.florian.esgiandroid.presentation.format

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ProductDetailsNutritionalValuesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProductDetailsNutritionalValuesFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(
            R.layout.fragment_product_details_nutritional_values,
            container,
            false
        )

        val product = DefaultProduct.dummy()

        v.findViewById<TextView>(R.id.c2_r2).text = product.nutritionFacts.energy.format()
        v.findViewById<TextView>(R.id.c2_r3).text = product.nutritionFacts.fats.format()
        v.findViewById<TextView>(R.id.c2_r4).text = product.nutritionFacts.saturedFats.format()
        v.findViewById<TextView>(R.id.c2_r5).text = product.nutritionFacts.glucids.format()
        v.findViewById<TextView>(R.id.c2_r6).text = product.nutritionFacts.sugars.format()
        v.findViewById<TextView>(R.id.c2_r7).text = product.nutritionFacts.fibers.format()
        v.findViewById<TextView>(R.id.c2_r8).text = product.nutritionFacts.proteins.format()
        v.findViewById<TextView>(R.id.c2_r9).text = product.nutritionFacts.salt.format()
        v.findViewById<TextView>(R.id.c2_r10).text = product.nutritionFacts.sodium.format()

        return v
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ProductDetailsNutritionalValuesFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProductDetailsNutritionalValuesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}