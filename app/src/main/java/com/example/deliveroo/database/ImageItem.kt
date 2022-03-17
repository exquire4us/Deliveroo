package com.example.deliveroo.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "unsplash_images")
data class ImageItem(
    @PrimaryKey (autoGenerate = true) var itemId: Int,
    @ColumnInfo(name = "image_id") val imageName : String,
    @ColumnInfo(name = "image_urls") val imageUrls : List<String>
)
