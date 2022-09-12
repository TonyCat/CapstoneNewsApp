package com.itscatalano.capstonenewsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.itscatalano.capstonenewsapp.databinding.ActivityMainBinding
import com.itscatalano.capstonenewsapp.databinding.ActivityNewsDetailBinding

class NewsDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


       val binding =  ActivityNewsDetailBinding.inflate(layoutInflater)

        setContentView(binding.root)



        val article =  intent.extras?.getParcelable<Article>("article")

        if (article != null) {
            binding.txtDescription.text = article.description
        }



    }
}