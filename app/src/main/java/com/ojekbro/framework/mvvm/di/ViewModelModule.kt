package com.ojekbro.framework.mvvm.di

import com.ojekbro.framework.mvvm.ui.main.viewmodel.MainViewModel
import com.ojekbro.framework.mvvm.ui.splash.SplashViewModel
import com.ojekbro.framework.mvvm.ui.usermanagement.login.LoginViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Comrade45 2020-10-19
 */

val viewModelModule = module {
    viewModel { MainViewModel(get(), get()) }
    viewModel { SplashViewModel(get(), get(), get()) }
    viewModel { LoginViewModel(get(), get()) }
}