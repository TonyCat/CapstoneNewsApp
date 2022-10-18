package com.itscatalano.capstonenewsapp.repo

import android.util.Log
import com.itscatalano.capstonenewsapp.dao.ArticleDao
import com.itscatalano.capstonenewsapp.dao.ArticleSourceDao
import com.itscatalano.capstonenewsapp.dao.SourceDao
import com.itscatalano.capstonenewsapp.models.Article
import com.itscatalano.capstonenewsapp.models.ArticleSource
import com.itscatalano.capstonenewsapp.models.Source
import com.itscatalano.capstonenewsapp.networking.NetworkStatusChecker
import com.itscatalano.capstonenewsapp.networking.RemoteApiService
import com.itscatalano.capstonenewsapp.utils.CustomResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow

const val TOKEN_KEY = "2f8cd5e3444b4e96bc6353df491c8d51"
class ArticleRepoImpl(
    private val articleDao: ArticleDao,
    private val sourceDao: SourceDao,
    private val articleSourceDao: ArticleSourceDao,
    private val newsApiService: RemoteApiService,
    private val dataStore: PreferencesDataStore,
    private val networkStatusChecker: NetworkStatusChecker
) : ArticleRepo {


    override suspend fun getArticles(): Flow<CustomResult<List<Article>>> {
        return flow {
            val newsFromLocalDb = articleDao.getArticles()

            emit(CustomResult.Success(newsFromLocalDb))

            Log.i(TAG, "newFromLocalDb size = ${newsFromLocalDb.size}")

            val isDownloadOverWifiOnly = dataStore.isDownloadOverWifiOnly().first()
            if (!isDownloadOverWifiOnly || (isDownloadOverWifiOnly && networkStatusChecker.hasWifiConnection())) {
                try {
                    val newsFromNetwork = newsApiService
                        .getArticles(TOKEN_KEY)
                        .articles
                    emit(CustomResult.Success(newsFromNetwork))
                    if (newsFromNetwork.isNotEmpty()) {
                        articleDao.deleteArticles()
                        sourceDao.deleteSources()
                        articleDao.addArticles(newsFromNetwork)
                    }

                } catch (error: Exception) {
                    Log.e(TAG, error.toString())
                }
            }
        }
    }

    override suspend fun addArticles(articles: List<Article>) = articleDao.addArticles(articles)

    override suspend fun clearArticles(article: Article) = articleDao.deleteArticles()

    override suspend fun searchArticles(search: String): List<Article> = articleDao.searchArticles(search)

    override suspend fun getArticleFromSources(articleTitle: String): ArticleSource =
        articleSourceDao.getArticleFromSources(articleTitle)

    override suspend fun getSources(): Source = sourceDao.getSources()

    override suspend fun addSources(source: Source) = sourceDao.addSources(source)

    override suspend fun clearSources() = sourceDao.deleteSources()


    companion object {
        private const val TAG = "ArticleRepoImpl"
    }
}
