package com.ojekbro.framework.mvvm.data.api

import com.ojekbro.framework.mvvm.data.model.api.User
import retrofit2.Response

interface ApiHelper {

    suspend fun getUsers(): Response<List<User>>
}