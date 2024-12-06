package com.example.myapplication

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.data.Product
import com.example.myapplication.data.ProductRepository


class SharedViewModel(app: Application) : AndroidViewModel(app) {

    private val _quantity: MutableLiveData<Int> = MutableLiveData(0)
    val quantity: LiveData<Int> = _quantity

    val products: MutableLiveData<List<Product>> = MutableLiveData()

    var productRepository: ProductRepository = ProductRepository()

    init {
        // Approach 1: Populate Products using resource file in the raw directory
        //val data = productRepository.getTextFromResource(app, R.raw.olive_oils_data)

        // Approach 2: Populate Products using resource file in the assets directory
        //val data = productRepository.getTextFromAsset(app, "olive_oils_data.json")
        // Log.i("two_trees_oil", data)

        val data = productRepository.getProducts(app)
        data?.let {
            products.value = it
        }

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