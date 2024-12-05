package com.example.myapplication

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.data.Stock

class MainViewModel(app: Application) : AndroidViewModel(app) {
    private val _stockInfo: MutableLiveData<Stock> = MutableLiveData()
    val stockInfo: LiveData<Stock> = _stockInfo

}