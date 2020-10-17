package com.ojekbro.framework.mvvm

import android.app.Application
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import com.orhanobut.hawk.Hawk
import dagger.hilt.android.HiltAndroidApp
import uk.co.chrisjenx.calligraphy.CalligraphyConfig
import javax.inject.Inject

@HiltAndroidApp
class App : Application() {

    @Inject
    lateinit var calConfig: CalligraphyConfig

    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        CalligraphyConfig.initDefault(calConfig)
        Hawk.init(applicationContext).setLogInterceptor { message ->
            if (BuildConfig.DEBUG) {
                Log.d("Hawk", message)
            }
        }.build()
    }
}


