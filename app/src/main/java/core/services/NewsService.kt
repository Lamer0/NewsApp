package core.services

import core.data.NewsRepository
import domain.models.Article

interface NewsService {

    suspend fun get(): List<Article>

    suspend fun get(id:Int): Article
}