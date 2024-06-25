package com.example.atl_unec2.base

import com.example.atl_unec2.coroutines.network.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

abstract class BaseRepository {

    protected fun <T> makeNetworkCall(call: suspend () -> Response<T>): Flow<Resource<T>> = flow {
        try {
            emit(Resource.Loading())
            val response = call()
            if (response.isSuccessful) {
                response.body()?.let {
                    emit(Resource.Success(it))
                } ?: throw Exception("Response body is null")
            } else {
                throw Exception(response.errorBody()?.string() ?: "Unknown error")
            }
        } catch (e: Exception) {
            emit(Resource.Error("Generic error happened"))
        }
    }
}