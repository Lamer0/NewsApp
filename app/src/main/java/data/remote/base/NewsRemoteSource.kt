package data.remote.base

import data.remote.responses.ArticleResponse

interface NewsRemoteSource {

    suspend fun getArticles():List<ArticleResponse>

    suspend fun getArticle(id:Int):ArticleResponse

    suspend fun getArticles(vararg queryData:Any):List<ArticleResponse>

}