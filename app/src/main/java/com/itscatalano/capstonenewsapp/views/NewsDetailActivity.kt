package com.itscatalano.capstonenewsapp.views

import android.content.Context
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.work.*
import com.itscatalano.capstonenewsapp.DownloadWorker
import com.itscatalano.capstonenewsapp.FileClearWorker
import com.itscatalano.capstonenewsapp.SepiaFilterWorker
import com.itscatalano.capstonenewsapp.databinding.ActivityNewsDetailBinding
import com.itscatalano.capstonenewsapp.models.Article
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NewsDetailActivity : AppCompatActivity() {

   private lateinit var  binding : ActivityNewsDetailBinding
    private val TAG = this.javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding =  ActivityNewsDetailBinding.inflate(layoutInflater)

        setContentView(binding.root)


        val article = intent.extras?.getParcelable<Article>("article")

        if (article != null) {

            println("Article is $article")

            binding.txtTitle.text = article.title
            binding.txtAuthor.text = article.author
            binding.txtDescription.text = article.description
        }

        article?.urlToImage?.let { downloadImage(it) }

    }

    private fun downloadImage(articleURL : String) {
        val constraints = Constraints.Builder()
            .setRequiresBatteryNotLow(true)
            .setRequiresStorageNotLow(true)
            .setRequiredNetworkType(NetworkType.NOT_ROAMING)
            .build()

        val clearFilesWorker = OneTimeWorkRequestBuilder<FileClearWorker>()
            .build()

        val data = Data.Builder()
            .putString("articleUrl",articleURL)
           // .put("article", article) if you want to pass in the whole object
            .build()

        val downloadRequest = OneTimeWorkRequestBuilder<DownloadWorker>()
            .setConstraints(constraints)
            .setInputData(data)
            .build()

        val sepiaFilterWorker = OneTimeWorkRequestBuilder<SepiaFilterWorker>()
            .setConstraints(constraints)
            .build()

        val workManager = WorkManager.getInstance(this)
        workManager.beginWith(clearFilesWorker)
            .then(downloadRequest)
            .then(sepiaFilterWorker)
            .enqueue()

        workManager.getWorkInfoByIdLiveData(sepiaFilterWorker.id).observe(this, Observer { info ->
            println("********In the getWorkInfoByIdLiveData")

            if (info.state.isFinished) {
                val imagePath = info.outputData.getString("image_path")

                if (!imagePath.isNullOrEmpty()) {
                    displayImage(imagePath)
                }else{
                     Log.e(TAG,"The image path is empty")
                }
            }
        })
    }

    private fun displayImage(imagePath: String) {

lifecycleScope.launch(Dispatchers.Main){
      //  GlobalScope.launch(Dispatchers.Main) {


            val bitmap = loadImageFromFile(imagePath)


            Log.d(TAG,"bitmap path is $imagePath")

            binding.detailImage.setImageBitmap(bitmap)
       }
    }

    private suspend fun loadImageFromFile(imagePath: String) = withContext(Dispatchers.IO) {
        BitmapFactory.decodeFile(imagePath)
    }



}