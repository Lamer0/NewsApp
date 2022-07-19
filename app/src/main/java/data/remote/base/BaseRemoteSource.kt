package data.remote.base

import com.squareup.moshi.JsonDataException
import com.squareup.moshi.JsonEncodingException
import com.squareup.moshi.Moshi
import data.remote.responses.ErrorResponse
import domain.models.BackendException
import domain.models.BackendInvalidResponseException
import domain.models.ConnectionException
import retrofit2.HttpException
import java.io.IOException
import java.lang.Exception

open class BaseRemoteSource(config: RetrofitConfig) : RemoteSource {

    private val moshi: Moshi = config.moshi
    private val errorAdapter = moshi.adapter(ErrorResponse::class.java)

    override suspend fun <T> wrapExceptions(block:suspend () -> T):T{

        return try {
            block()
        }
        catch (e:JsonDataException){

            throw BackendInvalidResponseException()

        }catch (e:JsonEncodingException){

            throw BackendInvalidResponseException()

        }catch (e:HttpException){

           throw createBackEndException(e)

        }catch (e:IOException){

            throw ConnectionException()

        }
    }

    override suspend fun createBackEndException(exception: HttpException):Exception{

        return try {

             val responseBody = errorAdapter.fromJson(exception.
             response()
                 !!.errorBody()
                 !!.string())!!


            BackendException(responseBody.code, responseBody.message)

        }catch(e:Exception) {

            throw BackendInvalidResponseException()

        }

    }
}