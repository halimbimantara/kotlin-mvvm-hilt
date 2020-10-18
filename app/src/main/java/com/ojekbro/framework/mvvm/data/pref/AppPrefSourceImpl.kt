package com.ojekbro.framework.mvvm.data.pref

class AppPrefSourceImpl() : PrefHelper {

    override suspend fun getUsername(): String {
        TODO("Not yet implemented")
    }

    override suspend fun setUsername(username: String) {
        TODO("Not yet implemented")
    }

    override suspend fun getPhoneNumbers(): String {
        return "prefHelper.getPhoneNumbers()"
    }

    override suspend fun setPhoneNumbers(Phone: String) {
//        prefHelper.setPhoneNumbers(Phone)
    }
}