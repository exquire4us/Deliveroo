package com.example.deliveroo.network

import com.example.deliveroo.model.MyPhoto
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

private const val   BASE_URL = "https://api.unsplash.com"
private const val  ACCESS_KEY ="CF3SkeC0ltxT_7rNcZqa1lREdmP5ZBWww3MWO2nb8wU"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface UnsplashApiServices {
    @Headers("Accept-Version: v1 ", "Authorization: Client-ID $ACCESS_KEY")
    @GET("photos/random")
    suspend fun getPhotos(
        @Query ("content_filter") content_filter: String = "high",
        @Query ("count") count :Int = 10,
        @Query ("query") query : String = "asian food on plate"
    ):List<MyPhoto>
}

object UnsplashApi{
    val retrofitService : UnsplashApiServices by lazy {
        retrofit.create(UnsplashApiServices::class.java)
    }
}
