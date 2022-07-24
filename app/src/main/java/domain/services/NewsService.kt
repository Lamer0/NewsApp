package domain.services

import core.data.NewsRepository
import core.services.NewsService
import domain.models.Article
//TODO Add mapping
class NewsService(private val repository: NewsRepository) : NewsService{


    override suspend fun get(): List<Article> {

        val response = repository.getNews()

        val articles:MutableList<Article> = emptyList<Article>() as MutableList<Article>

        response.forEach {

            articles.add(
                Article(
                    it.title,
                    it.imageUrl,
                    it.summary,
                    it.newsSite,
                    it.publishedAt
                )
            )

        }
        
        return articles
    }

    override suspend fun get(id:Int):Article {
        
        val response = repository.getArticle(id)

        return Article(
            response.title,
            response.imageUrl,
            response.summary,
            response.newsSite,
            response.publishedAt
        )
    }

}