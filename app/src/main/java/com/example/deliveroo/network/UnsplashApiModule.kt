package com.example.deliveroo.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UnsplashApiModule{
    private const val  BASE_URL = "https://api.unsplash.com"

    @Singleton
    @Provides
    fun providesMoshi(): Moshi = Moshi
        .Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    @Singleton
    @Provides
    fun providesHttpLoggingInterceptor() = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    @Singleton
    @Provides
    fun providesOkHttp(httpLoggingInterceptor: HttpLoggingInterceptor) : OkHttpClient =
       OkHttpClient
           .Builder()
           .connectTimeout(60, TimeUnit.SECONDS)
           .readTimeout(60,TimeUnit.SECONDS)
           .addInterceptor(httpLoggingInterceptor)
           .build()

    @Singleton
    @Provides
    fun providesRetrofit(okHttpClient: OkHttpClient, moshi : Moshi): Retrofit = Retrofit
        .Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .client(okHttpClient)
        .baseUrl(BASE_URL)
        .build()

    @Singleton
    @Provides
    fun providesApiService (retrofit: Retrofit) = retrofit.create(UnsplashApiServices::class.java)
}