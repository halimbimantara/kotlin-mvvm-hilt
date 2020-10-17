package com.ojekbro.framework.mvvm.di.module

import androidx.recyclerview.widget.LinearLayoutManager
import com.ojekbro.framework.mvvm.BuildConfig
import com.ojekbro.framework.mvvm.R
import com.ojekbro.framework.mvvm.data.api.ApiHelper
import com.ojekbro.framework.mvvm.data.api.ApiHelperImpl
import com.ojekbro.framework.mvvm.data.api.ApiService
import com.ojekbro.framework.mvvm.data.pref.AppPrefSourceImpl
import com.ojekbro.framework.mvvm.data.pref.PrefHelper
import com.ojekbro.framework.mvvm.utils.DEFAULT_FONT
import com.ojekbro.framework.mvvm.utils.rx.AppSchedulerProvider
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Singleton
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.converter.moshi.MoshiConverterFactory
import uk.co.chrisjenx.calligraphy.CalligraphyConfig

@Module
@InstallIn(ApplicationComponent::class)
class ApplicationModule {

    @Provides
    fun provideBaseUrl() = BuildConfig.BASE_URL

    @Provides
    @Singleton
    fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    } else OkHttpClient
        .Builder()
        .build()


    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        BASE_URL: String
    ): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

    @Provides
    @Singleton
    fun provideApiHelper(apiHelper: ApiHelperImpl): ApiHelper = apiHelper

    @Provides
    @Singleton
    fun provideAppPrefrences(appPref: AppPrefSourceImpl): PrefHelper = appPref

    @Provides
    @Singleton
    fun provideCalligraphy() {
        CalligraphyConfig.Builder()
            .setDefaultFontPath(DEFAULT_FONT)
            .setFontAttrId(R.attr.fontPath)
            .build()
    }

    @Provides
    @Singleton
    fun <SchedulerProvider> provideSchedulerProvider() {
        AppSchedulerProvider()
    }
}