package com.tahirdev.daggermvvm

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.tahirdev.daggermvvm.viewModels.MainViewModel
import com.tahirdev.daggermvvm.viewModels.MainViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel

    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory

    private val product : TextView
        get() = findViewById(R.id.productsTxt)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        (application as FakerApplication).appComponent.inject(this)

        val map = (application as FakerApplication).appComponent.getMap()

        mainViewModel = ViewModelProvider(this,mainViewModelFactory).get(MainViewModel::class.java)

        mainViewModel.productLiveData.observe(this, Observer {
                products ->
            if (products != null) {
                product.text = products.joinToString { it.title + "\n\n" }
            } else {
                Log.e("MainActivity", "Observed products list is null")
            }
        })



    }
}