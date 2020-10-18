package com.ojekbro.framework.mvvm.ui.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ojekbro.framework.mvvm.core.BaseViewModel
import com.ojekbro.framework.mvvm.data.repository.Repository
import com.ojekbro.framework.mvvm.utils.NetworkHelper
import com.ojekbro.framework.mvvm.utils.rx.SchedulerProvider

class SplashViewModel(
    private val mainRepository: Repository,
    private val schedulerProvider: SchedulerProvider,
    private val networkHelper: NetworkHelper
) : BaseViewModel() {
    private val _isLogin = MutableLiveData<Boolean>()
    val isLoged: LiveData<Boolean>
        get() = _isLogin

    init {
        fetchUsersLoged()
    }

    private fun fetchUsersLoged() {

    }
}