package com.itscatalano.capstonenewsapp

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.itscatalano.capstonenewsapp.databinding.NewsServiceLayoutBinding

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
             //   binding.sourceDescriptionTextView.text = article.source.description
            }

        }
