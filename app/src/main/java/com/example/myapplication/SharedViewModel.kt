package com.example.myapplication

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.data.ProductRepository


class SharedViewModel(app: Application) : AndroidViewModel(app) {

    private val _quantity: MutableLiveData<Int> = MutableLiveData(0)
    val quantity: LiveData<Int> = _quantity

    var productRepository: ProductRepository = ProductRepository()

    init {
        val data = productRepository.getTextFromResource(app, R.raw.olive_oils_data)
        Log.i("two_trees_oil", data)
    }

    fun increaseQuantity() {
        _quantity.value = _quantity.value!! + 1
    }

    fun decreaseQuantity() {
        if (_quantity.value!! > 0) {
            _quantity.value = _quantity.value!! - 1
        }

    }
}