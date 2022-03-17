package com.example.deliveroo.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "unsplash_images")
data class ImageItem(
    @PrimaryKey (autoGenerate = true) var itemId: Int = 0,
    @ColumnInfo(name = "image_id") val imageName : String,
    @ColumnInfo(name = "image_url_raw") val imageUrlRaw : String,
    @ColumnInfo(name = "image_url_regular") val imageUrlRegular : String,
    @ColumnInfo(name= "image_url_small") val imageUrlSmall : String,
    @ColumnInfo(name = "image_url_thumb") val imageUrlThumb: String

)
