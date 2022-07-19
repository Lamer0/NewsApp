package data.remote.base

import  data.remote.responses.ArticleResponse

interface NewsRepository {

    suspend fun getNews():List<ArticleResponse>

    suspend fun getArticle(id:Int):ArticleResponse

    suspend fun getArticles(vararg queryData:Any):List<ArticleResponse>
}