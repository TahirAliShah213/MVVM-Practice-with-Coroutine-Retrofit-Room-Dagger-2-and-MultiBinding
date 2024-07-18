package com.tahirdev.daggermvvm.di

import com.tahirdev.daggermvvm.retrofit.FakerAPI
import com.tahirdev.daggermvvm.utils.Constants
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit() : Retrofit{
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Singleton
    @Provides
    fun providesFakerAPi(retrofit: Retrofit) : FakerAPI {
        return retrofit.create(FakerAPI::class.java)
    }

}