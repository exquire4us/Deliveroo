package com.example.deliveroo.network

import com.example.deliveroo.model.MyPhoto
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
private const val  ACCESS_KEY ="0VNgJ1TaL3raZ_HIMipOOlbv8lVrAtoNMsyjdNwIOgc"


interface UnsplashApiServices {
    @Headers("Accept-Version: v1 ", "Authorization: Client-ID $ACCESS_KEY")
    @GET("/photos/random")
    suspend fun getChefPhotos(
        @Query("collections") collections : String  = "",
        @Query("username") username : String = "",
        @Query("query") query : String = "asian chef",
        @Query("orientation") orientation : String ="landscape",
        @Query("content_filter") content_filter: String = "low",
        @Query("count") count :Int = 10
    ):List<MyPhoto>

    @Headers("Accept-Version: v1 ", "Authorization: Client-ID $ACCESS_KEY")
    @GET("/photos/random")
    suspend fun getAsianFood(
        @Query("collections") collections : String  = "",
        @Query("username") username : String = "",
        @Query("query") query : String = "asian food",
        @Query("orientation") orientation : String ="landscape",
        @Query("content_filter") content_filter: String = "low",
        @Query("count") count :Int = 10
    ) : List<MyPhoto>

    @Headers("Accept-Version: v1 ", "Authorization: Client-ID $ACCESS_KEY")
    @GET("/photos/random")
    suspend fun getSnackPhotos(
        @Query("collections") collections : String  = "",
        @Query("username") username : String = "",
        @Query("query") query : String = "snacks",
        @Query("orientation") orientation : String ="landscape",
        @Query("content_filter") content_filter: String = "low",
        @Query("count") count :Int = 10
    ) : List<MyPhoto>

    @Headers("Accept-Version: v1 ", "Authorization: Client-ID $ACCESS_KEY")
    @GET("/photos/random")
    suspend fun getDessertPhotos(
        @Query("collections") collections : String  = "",
        @Query("username") username : String = "",
        @Query("query") query : String = "desserts",
        @Query("orientation") orientation : String ="landscape",
        @Query("content_filter") content_filter: String = "low",
        @Query("count") count :Int = 10
    ) :List<MyPhoto>

    @Headers("Accept-Version: v1 ", "Authorization: Client-ID $ACCESS_KEY")
    @GET("/photos/random")
    suspend fun getIceCreamPhotos(
        @Query("collections") collections : String  = "",
        @Query("username") username : String = "",
        @Query("query") query : String = "ice cream",
        @Query("orientation") orientation : String ="landscape",
        @Query("content_filter") content_filter: String = "low",
        @Query("count") count :Int = 10
    ):List<MyPhoto>



}

