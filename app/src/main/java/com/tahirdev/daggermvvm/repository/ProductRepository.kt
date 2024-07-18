package com.tahirdev.daggermvvm.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tahirdev.daggermvvm.db.FakerDB
import com.tahirdev.daggermvvm.models.ProductsItem
import com.tahirdev.daggermvvm.retrofit.FakerAPI
import javax.inject.Inject

class ProductRepository @Inject constructor(private val fakerAPI: FakerAPI, private val fakerDB: FakerDB) {

    private val _products = MutableLiveData<List<ProductsItem>>()
    val products : LiveData<List<ProductsItem>>
        get() = _products

    suspend fun getProduct(){
        try {
            val result = fakerAPI.getProducts()
            if (result.isSuccessful && result.body() != null) {
                _products.postValue(result.body())
                fakerDB.getDAO().addProducts(result.body()!!)
            } else {
                Log.e("ProductRepository", "Failed to fetch products: ${result.errorBody()?.string()}")
            }
        } catch (e: Exception) {
            Log.e("ProductRepository", "Exception in getProduct", e)
        }
    }

}