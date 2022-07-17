package data.remote.base

import retrofit2.HttpException
import java.lang.Exception

abstract class BaseRemoteSource() {

    abstract suspend fun <T> wrapExceptions(block:suspend () -> T):T

    abstract suspend fun createBackEndException(exception: HttpException):Exception
}