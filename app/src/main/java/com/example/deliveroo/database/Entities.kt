package com.example.deliveroo.database

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity (tableName = "chef_photos")
data class AsianChefPhotos(

    @PrimaryKey (autoGenerate = false )
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

@Entity(tableName ="asian_food_photos")
data class AsianFoodPhotos(
    @PrimaryKey (autoGenerate = false)
    val imageId: String,

    @ColumnInfo (name = "image_description")
    val description : String?,

    @ColumnInfo(name = "url_full")
    val full : String?

)

@Entity(tableName = "asian_snack_photos")
data class AsianSnackPhotos(
    @PrimaryKey (autoGenerate = false)
    val imageId: String,

    @ColumnInfo (name = "image_description")
    val description: String?,

    @ColumnInfo(name = "url_full")
    val full : String?


)

@Entity(tableName = "asian_dessert_photos")
data class AsianDessertPhotos(
    @PrimaryKey (autoGenerate = false)
    val imageId: String,

    @ColumnInfo (name = "image_description")
    val description: String?,

    @ColumnInfo(name = "url_full")
    val full : String?


)

@Entity(tableName = "asian_ice_cream_photos")
data class AsianIceCreamPhotos(
    @PrimaryKey (autoGenerate = false)
    val imageId: String,

    @ColumnInfo (name = "image_description")
    val description: String?,

    @ColumnInfo(name = "url_full")
    val full : String?


)


