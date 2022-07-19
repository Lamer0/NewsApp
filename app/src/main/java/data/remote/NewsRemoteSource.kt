package data.remote

import data.remote.base.BaseRemoteSource
import data.remote.base.NewsDao
import data.remote.base.RetrofitConfig

class NewsRemoteSource(config:RetrofitConfig) : BaseRemoteSource(config), NewsDao  {

    private val api = config.retrofit.create(NewsApi::class.java)

    override suspend fun getArticle(id:Int) =
        wrapExceptions { api.getArticle(id) }

    override suspend fun getArticles() =
        wrapExceptions { api.getArticles() }

    override suspend fun getArticles(vararg requesData:Any) =
        wrapExceptions {
            api.getArticles(requesData[0].toString().toInt(), requesData[1].toString().toInt())
        }
}