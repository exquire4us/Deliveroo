package com.example.deliveroo.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [AsianChefPhotos::class, AsianFoodPhotos::class, AsianDessertPhotos::class,AsianSnackPhotos::class,AsianIceCreamPhotos::class], version = 2)
abstract class ImageDatabase : RoomDatabase(){
    abstract fun imageItemDao() : DatabaseDao
}