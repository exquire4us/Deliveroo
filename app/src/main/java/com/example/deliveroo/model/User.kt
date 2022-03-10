package com.example.deliveroo.model

import android.graphics.drawable.Drawable
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
    var description : String?,
    var urls: PhotoUrls
)
data class PhotoUrls(
    var raw: String,
    var full: String,
    var regular: String,
    var thumb: String
)

