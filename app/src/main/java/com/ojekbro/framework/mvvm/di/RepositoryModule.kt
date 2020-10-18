package com.ojekbro.framework.mvvm.di

import com.ojekbro.framework.mvvm.data.repository.AppRepository
import com.ojekbro.framework.mvvm.data.repository.Repository
import org.koin.dsl.module

/**
 * Comrade45 2020-10-19
 */


val repositoryModule = module {
    factory<Repository> {
        AppRepository(get(), get())
    }
}