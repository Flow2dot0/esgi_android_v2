package com.florian.esgiandroid.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.florian.esgiandroid.R

class ProductsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)
    }
}


class ListAdapter : RecyclerView.Adapter<ListItemCell>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemCell {
        return ListItemCell(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_product, parent, false)
        )
    }

    override fun onBindViewHolder(cell: ListItemCell, position: Int) {
        cell.text.text = position.toString()
    }

    override fun getItemCount(): Int {
        return 40
    }

}
//
//class ListItemCell(v: View) : RecyclerView.ViewHolder(v) {
//
//    val text : TextView = v.text_cell
//
//}
