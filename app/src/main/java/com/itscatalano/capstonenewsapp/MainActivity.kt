package com.itscatalano.capstonenewsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.itscatalano.capstonenewsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        // set content view after binding
        val view = binding.root
        setContentView(view)

        val mainGroup = binding.mainGroup
    }
}