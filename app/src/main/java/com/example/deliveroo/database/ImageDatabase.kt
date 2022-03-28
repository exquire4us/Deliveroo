package com.example.deliveroo.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ImageItem::class], version = 1)
abstract class ImageDatabase : RoomDatabase(){
    abstract fun imageItemDao() : DatabaseDao
}