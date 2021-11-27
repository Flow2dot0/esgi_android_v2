package com.florian.esgiandroid

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.style.StyleSpan
import android.util.Log
import android.widget.TextView
import android.widget.Toast

class PlaygroundActivity : AppCompatActivity() {
    private val TAG = "PlaygroundActivity"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playground)

        val text = "Hello World"
        val duration = Toast.LENGTH_SHORT

        val toast = Toast.makeText(applicationContext, text, duration)
        toast.show()

        Log.v(TAG, text)

    }


    private fun valueOfText(rId : Int, rString : Int, args : String){
        findViewById<TextView>(rId).setTextBold(getString(rString, args))
    }



    private fun TextView.setTextBold(text: String, separator: String = ":") {
        val builder = SpannableStringBuilder(text)
        builder.setSpan(StyleSpan(Typeface.BOLD), 0, text.indexOf(separator) + 1, 0)
        setText(builder)
    }

    private fun List<String>.formatItemsFromList() : String{
        return this.toString().substring(1, this.toString().length-1)
    }
}


