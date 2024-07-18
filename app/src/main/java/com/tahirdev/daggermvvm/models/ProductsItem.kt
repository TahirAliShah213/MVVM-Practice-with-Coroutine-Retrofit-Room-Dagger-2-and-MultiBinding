package com.tahirdev.daggermvvm.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ProductsItem(
    val category: String,
    val description: String,
    @PrimaryKey(false)
    val id: Int,
    val image: String,
    val price: Double,
    val title: String
)