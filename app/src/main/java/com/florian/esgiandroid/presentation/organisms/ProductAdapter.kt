package com.florian.esgiandroid.presentation.organisms

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.florian.esgiandroid.R
import com.florian.esgiandroid.domain.DefaultProduct
import com.florian.esgiandroid.domain.PicassoImageLoader
import com.florian.esgiandroid.domain.Product

class ProductAdapter(val products : ArrayList<Product>) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val viewItem = inflater.inflate(R.layout.item_product, parent, false)
        return ViewHolder(viewItem).listen { position, type ->
            val action = ProductsFragmentDirections.actionProductsFragmentToProductDetailsFragment(
                DefaultProduct.from(products[position]))
            viewItem.findNavController().navigate(action)
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products[position]
        PicassoImageLoader().loadInto(imageUrl = product.imageUrl, destination = holder.banner)
        holder.name.text = product.name
        holder.brand.text = product.brand
        holder.nutriscore.text = product.nutriscore.substring(product.nutriscore.length-1, product.nutriscore.length).uppercase()
        holder.calories.text = product.nutritionFacts.calories.quantityPer100g.toInt().toString()
    }

    override fun getItemCount(): Int = products.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val banner = itemView.findViewById<ImageView>(R.id.item_product_card_banner)
        val name = itemView.findViewById<TextView>(R.id.item_product_name)
        val brand = itemView.findViewById<TextView>(R.id.item_product_brand)
        val nutriscore = itemView.findViewById<TextView>(R.id.item_product_value_nutriscore)
        val calories = itemView.findViewById<TextView>(R.id.item_product_value_calories)
    }

    fun <T : RecyclerView.ViewHolder> T.listen(event: (position: Int, type: Int) -> Unit): T {
        itemView.setOnClickListener {
            event.invoke(getAdapterPosition(), getItemViewType())
        }
        return this
    }
}

