package com.example.deliveroo.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.deliveroo.model.PhotoUrls

@Entity (tableName = "unsplash_images")
data class ImageItem(
    @PrimaryKey (autoGenerate = true) var itemId: Int = 0,
    @ColumnInfo(name = "image_id") val imageId : String,
    @ColumnInfo(name ="image_urls") val photosUrl :ImageUrls

)
data class ImageUrls(
    var raw: String,
    var full: String,
    var regular: String,
    var thumb: String
)
