package com.example.deliveroo.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ImageItemDao {
    @Query ("SELECT * from unsplash_images")
    fun getAllPhotos (): LiveData<List<ImageItem>>

    @Query ("SELECT * from unsplash_images Where image_id = :imageId")
    fun getByImageId (imageId: String): ImageItem?

    @Insert
    suspend fun insert (item: ImageItem)

    @Update
    suspend fun update (item: ImageItem)

    @Delete
    suspend fun delete (item: ImageItem)

    @Query ("DELETE FROM unsplash_images")
    suspend fun deleteAllImageItems ()
}