package com.tahirdev.daggermvvm.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class MainViewModel2 @Inject constructor(private val randomize: Randomize) : ViewModel() {
    fun doAction(){
        Log.d("TAG","Random Action")
    }
}