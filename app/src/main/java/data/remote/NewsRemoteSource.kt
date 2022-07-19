package data.remote

import data.remote.base.BaseRemoteSource
import data.remote.base.RetrofitConfig

class NewsRemoteSource(config:RetrofitConfig) : BaseRemoteSource(config)  {

    private val api = config.retrofit.create(NewsApi::class.java)

    suspend fun getArticle(id:Int) = api.getArticle(id)

    suspend fun getArticles() = api.getArticles()

    suspend fun getArticles(limit:Int, starAt:Int) = api.getArticles(limit, starAt)
}