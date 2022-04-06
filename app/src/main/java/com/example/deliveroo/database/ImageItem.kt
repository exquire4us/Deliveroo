package com.example.deliveroo.database

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.deliveroo.model.PhotoUrls

@Entity (tableName = "my_photos")
data class ImageItem(

    @PrimaryKey (autoGenerate = false ) @NonNull
    val imageId : String,

    @ColumnInfo(name = "images_full")
    val full : String?,

    @ColumnInfo(name ="image_regular")
    val regular : String?,

    @ColumnInfo(name = "image_raw")
    val raw: String?,

    @ColumnInfo(name= "image_thumb")
    val thumb: String?

)

@Entity(tableName ="Popular_and_New_ Photos ")
data class Popularphotos(
    @PrimaryKey (autoGenerate = false) @NonNull
    val imageId: String,

    @ColumnInfo (name = "image_description")
    val description : String?,

    @ColumnInfo(name = "url_full")
    val full : String?

)
