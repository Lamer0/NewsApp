package domain.models

sealed class Result<T> {

    class Success<T>(
        val value: T
    ) : Result<T>()

    class Error<T>(val error: Throwable) : Result<T>()

    class Empty<T> : Result<T>()

    class Loading<T> : Result<T>()
}
