package com.tahirdev.daggermvvm.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tahirdev.daggermvvm.models.ProductsItem

@Dao
interface FakerDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addProducts(productsItem: List<ProductsItem>)

    @Query("SELECT * FROM ProductsItem")
    suspend fun getProducts() : List<ProductsItem>

}