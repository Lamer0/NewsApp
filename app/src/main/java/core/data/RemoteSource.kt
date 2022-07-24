package core.data

import retrofit2.HttpException
import java.lang.Exception

interface RemoteSource {

    suspend fun <T> wrapExceptions(block:suspend () -> T):T

    suspend fun createBackEndException(exception: HttpException): Exception

}