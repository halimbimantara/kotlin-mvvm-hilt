package com.ojekbro.framework.mvvm.ui.usermanagement.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ojekbro.framework.mvvm.core.BaseViewModel
import com.ojekbro.framework.mvvm.data.repository.Repository
import com.ojekbro.framework.mvvm.utils.NetworkHelper
import kotlinx.coroutines.launch

class LoginViewModel (
    private val mainRepository: Repository,
    private val networkHelper: NetworkHelper
) : BaseViewModel() {

    private val _isLogin = MutableLiveData<Boolean>()
    val isLoged: LiveData<Boolean>
        get() = _isLogin

    init {
        fetchUsersLoged()
    }

    private fun fetchUsersLoged() {
        viewModelScope.launch {
//            if (mainRepository.getIsLoged().isNotEmpty())
//                _isLogin.postValue(true)
//            else
//                _isLogin.postValue(false)
        }
    }
}