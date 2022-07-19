package data.remote

import data.remote.base.BaseRemoteSource
import data.remote.base.RetrofitConfig

class NewsRemoteSource(config:RetrofitConfig) : BaseRemoteSource(config)  {

    private val api = config.retrofit.create(NewsApi::class.java)

    suspend fun getArticle(id:Int) =
        wrapExceptions { api.getArticle(id) }

    suspend fun getArticles() =
        wrapExceptions { api.getArticles() }

    suspend fun getArticles(limit:Int, starAt:Int) =
        wrapExceptions { api.getArticles(limit, starAt) }
}