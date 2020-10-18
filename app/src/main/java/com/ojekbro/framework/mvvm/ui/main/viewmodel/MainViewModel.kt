package com.ojekbro.framework.mvvm.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ojekbro.framework.mvvm.core.BaseViewModel
import com.ojekbro.framework.mvvm.data.model.api.User
import com.ojekbro.framework.mvvm.data.repository.Repository
import com.ojekbro.framework.mvvm.utils.NetworkHelper
import com.ojekbro.framework.mvvm.utils.Resource

class MainViewModel (
    private val mainRepository: Repository,
    private val networkHelper: NetworkHelper
) : BaseViewModel() {

    private val _users = MutableLiveData<Resource<List<User>>>()
    val users: LiveData<Resource<List<User>>>
        get() = _users

    init {
//        fetchUsers()
    }


}