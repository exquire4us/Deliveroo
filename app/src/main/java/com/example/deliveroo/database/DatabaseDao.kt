package com.example.deliveroo.database

import androidx.lifecycle.LiveData
import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface DatabaseDao {
    @Query ("SELECT * from my_photos")
    fun getAllPhotos (): List<ImageItem>

    @Insert
    suspend fun insert (item: ImageItem)

    @Update
    suspend fun update (item: ImageItem)

    @Delete
    suspend fun delete (item: ImageItem)

    @Query ("DELETE FROM my_photos")
    suspend fun deleteAllImageItems ()
}