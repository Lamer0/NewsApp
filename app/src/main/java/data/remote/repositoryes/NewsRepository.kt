package data.remote.repositoryes

import core.data.NewsDao
import core.data.NewsRepository
import data.remote.responses.ArticleResponse

/***
 * Get "raw" news from DAO
 */
class NewsRepository(private val newsDao: NewsDao) : NewsRepository {

    override suspend fun getNews(): List<ArticleResponse> {
        return  newsDao.getArticles()
    }

    override suspend fun getArticle(id: Int): ArticleResponse {
        return  newsDao.getArticle(id)
    }

    override suspend fun getArticles(vararg queryData: Any): List<ArticleResponse> {
        return  newsDao.getArticles(queryData[0], queryData[1])
    }


}