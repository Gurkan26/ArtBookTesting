package com.gurkan.artbooktesting.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gurkan.artbooktesting.R
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var fragmentFactory: ArtFragmentFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.fragmentFactory=fragmentFactory
        setContentView(R.layout.activity_main)
    }
}