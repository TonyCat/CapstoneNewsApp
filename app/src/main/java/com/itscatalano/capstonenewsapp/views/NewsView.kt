package com.itscatalano.capstonenewsapp.views

import android.content.Context
import android.graphics.BitmapFactory
import android.os.Handler
import android.os.Looper
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.bumptech.glide.Glide
import com.itscatalano.capstonenewsapp.databinding.NewsServiceLayoutBinding
import com.itscatalano.capstonenewsapp.models.Article
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.net.HttpURLConnection
import java.net.URL

class NewsView @JvmOverloads constructor (
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0,
        ): ConstraintLayout(context, attrs,defStyleAttr,defStyleRes){

            private val binding = NewsServiceLayoutBinding.inflate(LayoutInflater.from(context), this)

            fun setData(article: Article){



                binding.titleTextView.text = article.title
                binding.authorTextView.text = article.author

                Glide.with(context).load(article.urlToImage).into(binding.newsImage)

//get the images on their own thread
                Log.d("TaskThread", Thread.currentThread().name)
//                GlobalScope.launch(context = Dispatchers.IO) {
//                    Log.d("TaskThread", Thread.currentThread().name)
//                    val imageURL =  URL(article.urlToImage)
//                    val connection = imageURL.openConnection() as HttpURLConnection
//                    connection.doInput = true
//                    connection.connect()
//
//                    val inputStream = connection.inputStream
//                    val bitmap = BitmapFactory.decodeStream(inputStream)
//
//                    launch (Dispatchers.Main){
//                        Log.d("TaskThread", Thread.currentThread().name)
//                        binding.newsImage.setImageBitmap(bitmap)
//                    }
//
//
//
//                }




           }

       }
