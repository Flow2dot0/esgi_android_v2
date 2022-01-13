package com.florian.esgiandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.florian.esgiandroid.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        val view = binding.root
        val splashScreen = installSplashScreen()
        setContentView(view)
        setTheme(R.style.BaseTheme)
        supportActionBar?.setBackgroundDrawable(
            ContextCompat.getDrawable(
                this,
                R.drawable.toolbar_drawable
            )
        )
    }
}