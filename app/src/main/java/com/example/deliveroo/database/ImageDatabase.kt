package com.example.deliveroo.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

@Database(entities = [ImageItem::class], version = 1)
abstract class ImageDatabase : RoomDatabase(){
    abstract fun imageItemDao() : ImageItemDao
    companion object {
        private var INSTANCE : ImageDatabase? = null
        @OptIn(InternalCoroutinesApi::class)
        fun getInstance(context: Context): ImageDatabase {
            synchronized(this){
                var instance = INSTANCE

                if (instance == null){
                        instance = Room.databaseBuilder(
                            context.applicationContext,
                            ImageDatabase::class.java,
                            "unsplash_images_database"
                        ).fallbackToDestructiveMigration()
                            .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}