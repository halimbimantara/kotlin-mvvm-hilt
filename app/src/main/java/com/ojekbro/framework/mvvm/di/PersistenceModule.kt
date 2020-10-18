package com.ojekbro.framework.mvvm.di

import com.ojekbro.framework.mvvm.data.pref.AppPrefSourceImpl
import org.koin.dsl.module

val persistenceModule = module {
    single {
        AppPrefSourceImpl()
    }
}


