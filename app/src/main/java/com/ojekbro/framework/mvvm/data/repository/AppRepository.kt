package com.ojekbro.framework.mvvm.data.repository

import com.ojekbro.framework.mvvm.data.api.AppRemoteSource
import com.ojekbro.framework.mvvm.data.pref.AppPrefSourceImpl
import io.reactivex.Observable
import retrofit2.HttpException
import java.net.SocketTimeoutException
import java.net.UnknownHostException


data class Result<out T>(
    val data: T? = null,
    val error: Throwable? = null
)

fun <T> Observable<T>.responseToResult(): Observable<Result<T>> {
    return map { it.asResult() }
        .onErrorReturn {
            when (it) {
                is HttpException,
                is SocketTimeoutException,
                is UnknownHostException -> {
                    it.asErrorResult()
                }
                else -> throw it
            }
        }
}

fun <T> T.asResult(): Result<T> = Result(data = this, error = null)
fun <T> Throwable.asErrorResult(): Result<T> = Result(data = null, error = this)

open class AppRepository constructor(
    private val api: AppRemoteSource,
    private val pref: AppPrefSourceImpl
) : Repository {


}