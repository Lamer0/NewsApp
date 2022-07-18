package data.remote

import data.remote.base.RestApi
import data.remote.responses.ArticleResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NewsApi : RestApi{

    @GET("articles/{id}")
    suspend fun getArticle(@Path("id")id:Int):ArticleResponse

    @GET("articles/?_limit=128&_start=1")
    suspend fun getArticles():List<ArticleResponse>

    @GET("articles/")
    suspend fun getArticles(@Query("_limit")limit:Int,
                            @Query("_start")star:Int):List<ArticleResponse>
}