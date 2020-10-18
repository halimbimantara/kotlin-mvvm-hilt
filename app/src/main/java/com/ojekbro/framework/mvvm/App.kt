package com.ojekbro.framework.mvvm

import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import androidx.multidex.MultiDexApplication
import com.ojekbro.framework.mvvm.di.appModule
import com.ojekbro.framework.mvvm.di.networkModule
import com.ojekbro.framework.mvvm.di.persistenceModule
import com.ojekbro.framework.mvvm.di.viewModelModule
import com.orhanobut.hawk.Hawk
import com.ojekbro.framework.mvvm.di.repositoryModule
import io.github.inflationx.calligraphy3.CalligraphyConfig
import io.github.inflationx.calligraphy3.CalligraphyInterceptor
import io.github.inflationx.viewpump.ViewPump
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : MultiDexApplication() {
    private val calConfig: CalligraphyConfig by inject()

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(networkModule)
            modules(persistenceModule)
            modules(repositoryModule)
            modules(appModule)
            modules(viewModelModule)
        }
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        ViewPump.init(
            ViewPump.builder().addInterceptor(
                CalligraphyInterceptor(calConfig)
            ).build()
        )
        Hawk.init(applicationContext).setLogInterceptor { message ->
            if (BuildConfig.DEBUG) {
                Log.d("Hawk", message)
            }
        }.build()
    }
}


