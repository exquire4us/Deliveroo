package com.example.deliveroo.database

import androidx.room.*

@Dao
interface DatabaseDao {
    @Query ("SELECT * from chef_photos")
    fun getAllChefPhotos (): List<AsianChefPhotos>

    @Query ("SELECT * from asian_food_photos")
    fun getAllAsianFoodPhotos (): List<AsianFoodPhotos>

    @Query("SELECT * from asian_dessert_photos")
    fun getAllAsianDessertPhotos (): List<AsianDessertPhotos>

    @Query ("SELECT * from asian_snack_photos")
    fun getAllAsianSnackPhotos (): List<AsianSnackPhotos>

    @Query ("SELECT * from asian_ice_cream_photos")
    fun getAllAsiaIceCreamPhotos (): List<AsianIceCreamPhotos>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertChefPhoto (item: AsianChefPhotos)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAsianFoodPhoto(item: AsianFoodPhotos)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAsianSnackPhoto(item: AsianSnackPhotos)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAsianIceCreamPhoto(item: AsianIceCreamPhotos)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAsianDessertPhoto(item: AsianDessertPhotos)



    @Update
    suspend fun update (item: AsianChefPhotos)

    @Delete
    suspend fun delete (item: AsianChefPhotos)

    @Query ("DELETE FROM chef_photos ")
    suspend fun deleteAllImageItems ()

}