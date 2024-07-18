package com.tahirdev.daggermvvm

import android.app.Application
import com.tahirdev.daggermvvm.di.ApplicationComponent
import com.tahirdev.daggermvvm.di.DaggerApplicationComponent
import dagger.Component

class FakerApplication : Application() {

    lateinit var appComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerApplicationComponent.factory().create(this)
    }
}