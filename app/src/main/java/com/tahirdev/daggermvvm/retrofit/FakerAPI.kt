package com.tahirdev.daggermvvm.retrofit

import com.tahirdev.daggermvvm.models.ProductsItem
import retrofit2.Response
import retrofit2.http.GET

interface FakerAPI {

    @GET("products")
    suspend fun getProducts() : Response<List<ProductsItem>>

}