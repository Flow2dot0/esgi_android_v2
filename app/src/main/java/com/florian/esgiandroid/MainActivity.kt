package com.florian.esgiandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.graphics.Insets.add
import androidx.fragment.app.commit
import com.florian.esgiandroid.presentation.organisms.ProductDetailsFragment
import com.florian.esgiandroid.presentation.organisms.ProductsFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.BaseTheme)
        setContentView(R.layout.main_activity)
        supportActionBar?.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.toolbar_drawable))

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                .replace(R.id.container_view1, ProductDetailsFragment())
            }
        }
    }
}