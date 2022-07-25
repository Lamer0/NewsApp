package data.remote.responses

/***
 * Represents response from API
 */
data class ArticleResponse(
    val events: List<EventResponse>,
    val featured: Boolean,
    val id: Int,
    val imageUrl: String,
    val launches: List<LauncheResponse>,
    val newsSite: String,
    val publishedAt: String,
    val summary: String,
    val title: String,
    val url: String
)