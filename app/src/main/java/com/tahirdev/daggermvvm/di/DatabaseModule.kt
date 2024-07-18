package com.tahirdev.daggermvvm.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.tahirdev.daggermvvm.db.FakerDB
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideFakerDb(context: Context) : FakerDB {
        return Room.databaseBuilder(context,FakerDB::class.java,"FakerDB").build()
    }
}