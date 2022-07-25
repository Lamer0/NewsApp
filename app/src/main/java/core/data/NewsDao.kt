package core.data

import data.remote.responses.ArticleResponse

/***
 * Represents methods for any news DAO
 */
interface NewsDao{

    suspend fun getArticles():List<ArticleResponse>

    suspend fun getArticle(id:Int): ArticleResponse

    suspend fun getArticles(vararg queryData:Any):List<ArticleResponse>

}