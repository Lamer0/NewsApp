package data.remote.repositoryes

import data.remote.base.NewsRemoteSource
import data.remote.base.NewsRepository
import data.remote.responses.ArticleResponse

class NewsRepository(private val newsDao:NewsRemoteSource) : NewsRepository {

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