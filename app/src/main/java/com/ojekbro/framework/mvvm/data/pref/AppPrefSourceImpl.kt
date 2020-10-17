package com.ojekbro.framework.mvvm.data.pref

import com.ojekbro.framework.mvvm.utils.CacheKey
import com.orhanobut.hawk.Hawk
import javax.inject.Inject

class AppPrefSourceImpl @Inject constructor(private val prefHelper: PrefHelper) : PrefHelper {
    fun getUsername() = Hawk.get(CacheKey.PREF_USERNAME, "")!!
    fun setUsername(username: String) = Hawk.put(CacheKey.PREF_USERNAME, username)

    override fun getPhoneNumbers(): String {
        TODO("Not yet implemented")
    }

    override fun setPhoneNumbers(Phone: String): String {
        TODO("Not yet implemented")
    }
}