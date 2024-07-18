package com.tahirdev.daggermvvm.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tahirdev.daggermvvm.models.ProductsItem
import com.tahirdev.daggermvvm.repository.ProductRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(private val repository: ProductRepository, private val randomize: Randomize) : ViewModel() {

    val productLiveData : LiveData<List<ProductsItem>>
        get() = repository.products

    init {
        viewModelScope.launch {
            repository.getProduct()
        }
    }

}


class Randomize @Inject constructor(){
    fun doAction(){
        Log.d("TAG","Random Action")
    }
}