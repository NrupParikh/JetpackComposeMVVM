package com.nrup.countrylist.di

import android.app.Application
import android.content.Context
import com.nrup.countrylist.domain.repository.CountryRepository
import com.nrup.countrylist.network.repository.CountryRepositoryImpl
import com.nrup.countrylist.network.service.CountryService
import com.nrup.countrylist.utils.Const.BASE_URL
import com.nrup.countrylist.utils.networkcheck.NetworkConnectionInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    // Returns Application context singleton object
    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application
    }

    // Returns OkHttpClient singleton object
    @Provides
    @Singleton
    fun provideAuthInterceptorOkHttpClient(context: Context): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .addInterceptor(NetworkConnectionInterceptor(context))
            .build()
    }

    // Returns Retrofit singleton object
    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // Returns CountryList API Service singleton object
    @Provides
    @Singleton
    fun provideCountryService(
        retrofit: Retrofit
    ): CountryService = retrofit.create(CountryService::class.java)

    @Provides
    fun provideCountryRepository(
        countryService: CountryService
    ): CountryRepository = CountryRepositoryImpl(
        countryService = countryService
    )

}