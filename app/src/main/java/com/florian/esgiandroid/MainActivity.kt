package com.florian.esgiandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.florian.esgiandroid.domain.DefaultProduct
import com.florian.esgiandroid.presentation.organisms.ProductAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.BaseTheme)
        setContentView(R.layout.main_activity)
        supportActionBar?.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.toolbar_drawable))

        val fragment = ProductsFragment.newInstance("", "");

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.container_view1, fragment)
                .commitAllowingStateLoss()
        }
    }
}