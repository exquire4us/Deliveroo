package com.example.deliveroo.model

import android.graphics.drawable.Drawable
import androidx.room.Entity
import com.squareup.moshi.Json
import kotlinx.serialization.Serializable

@Serializable
data class User(
    val name: String ,
    val password: String ,
    val email: String
    )
data class MyPhoto(
    @Json(name = "id") var id: String,
    @Json (name  ="description")var description : String?,
    @Json (name = "urls")var urls: PhotoUrls
)
data class PhotoUrls(
    @Json (name= "raw")var raw: String,
    @Json (name = "full")var full: String,
    @Json (name= "regular")var regular: String,
    @Json (name ="thumb")var thumb: String
)

