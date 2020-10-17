package com.ojekbro.framework.mvvm.data.api

import com.ojekbro.framework.mvvm.data.model.api.User
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    suspend fun getUsers(): Response<List<User>>

}