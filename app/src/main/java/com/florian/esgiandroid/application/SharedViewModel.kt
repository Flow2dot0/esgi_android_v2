package com.florian.esgiandroid.application

import android.content.ClipData
import android.os.Bundle
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.florian.esgiandroid.domain.DefaultProduct
import com.florian.esgiandroid.domain.Product
import java.nio.channels.Selector

class SharedViewModel : ViewModel() {
    var product : DefaultProduct? = null

    fun set(item: DefaultProduct) {
        product = item
    }
}
