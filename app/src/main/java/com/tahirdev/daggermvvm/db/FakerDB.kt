package com.tahirdev.daggermvvm.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tahirdev.daggermvvm.models.ProductsItem

@Database(entities = [ProductsItem::class], version = 1)
abstract class FakerDB : RoomDatabase() {

    abstract fun getDAO() : FakerDAO



}