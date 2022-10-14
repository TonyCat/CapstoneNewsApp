package com.itscatalano.capstonenewsapp.repo

import android.util.Log
import com.itscatalano.capstonenewsapp.dao.ArticleDao
import com.itscatalano.capstonenewsapp.dao.SourceDao
import com.itscatalano.capstonenewsapp.models.Article
import com.itscatalano.capstonenewsapp.networking.RemoteApiService
import com.itscatalano.capstonenewsapp.utils.CustomResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class ArticleRepoImpl(
    private val articleDao: ArticleDao,
    private val sourceDao: SourceDao,
    private val newsApiService: RemoteApiService,
) : ArticleRepo {
    override fun getArticles(): Flow<CustomResult<List<Article>>> {
//    override fun getArticles(): Flow<CustomResult<List<Article>>> {
        return flow {
            val articlesFromLocalDb = articleDao.getArticles()

            emit(CustomResult.Success(articlesFromLocalDb))

            Log.i(TAG, "articlesFromLocalDb size = ${articlesFromLocalDb.size}")

            try {
                val articlesFromNetwork = newsApiService
                    .getAllNews()
                    .articles

//                val articleAndSourceList = articlesFromNetwork
//                    .map { articleDto ->
//                        val article = Article(
//                            articleDto.title,
//                            articleDto.author,
//                            articleDto.description,
//                            articleDto.url,
//                            articleDto.source.name,
//                        )
//                        ArticleAndSource(article, articleDto.source)
//                    }
                emit(CustomResult.Success(articlesFromNetwork))
                if (articlesFromNetwork.isNotEmpty()) {
                    articleDao.deleteArticles()
                    sourceDao.deleteSources()
                    articlesFromNetwork.forEach { article ->
                        sourceDao.addSource(article.source)
                    }
                    articleDao.addArticles(articlesFromNetwork)
                }
            } catch (e: Exception) {
                //emit(CustomResult.Failure(e.message ?: "Unknown Failure"))
                Log.e(TAG, e.toString())
            }
        }
    }

    companion object {
        private const val TAG = "ArticleRepoImpl"
    }
}
