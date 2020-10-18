package com.ojekbro.framework.mvvm.data.pref

interface PrefHelper {
    suspend fun getUsername(): String
    suspend fun setUsername(username: String)
    suspend fun getPhoneNumbers(): String
    suspend fun setPhoneNumbers(Phone: String)
}