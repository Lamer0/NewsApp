package data.remote.responses

/***
 * Represents error response from API
 */
data class ErrorResponse(
    val code: Int,
    val message: String
)