package com.ojekbro.framework.mvvm.di

import androidx.recyclerview.widget.LinearLayoutManager
import com.ojekbro.framework.mvvm.R
import com.ojekbro.framework.mvvm.utils.rx.AppSchedulerProvider
import com.ojekbro.framework.mvvm.utils.rx.SchedulerProvider
import io.github.inflationx.calligraphy3.CalligraphyConfig
import org.koin.dsl.module

const val DEFAULT_FONT = "fonts/GoogleSans-Regular.ttf"

val appModule = module {

    single {
        CalligraphyConfig.Builder()
            .setDefaultFontPath(com.ojekbro.framework.mvvm.utils.DEFAULT_FONT)
            .setFontAttrId(R.attr.fontPath)
            .build()
    }

    factory<SchedulerProvider> {
        AppSchedulerProvider()
    }


    factory {
        LinearLayoutManager(get())
    }

}