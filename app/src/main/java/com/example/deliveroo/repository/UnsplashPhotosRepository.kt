package com.example.deliveroo.repository

import com.example.deliveroo.database.DatabaseDao
import com.example.deliveroo.database.ImageItem
import com.example.deliveroo.network.UnsplashApiServices
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UnsplashPhotosRepository @Inject constructor (
    private val databaseDao : DatabaseDao,
    private val apiService: UnsplashApiServices
        ) {
    val readData  = flow<List<ImageItem>> {
        val databasePhotos = databaseDao.getAllPhotos()
        if (databasePhotos.isEmpty()){

            val apiPhotos = getPhotos()
            for (photo in apiPhotos){
                addImage(imageItem = ImageItem(
                    imageId = photo.id,
                    full = photo.urls.full,
                    regular = photo.urls.regular,
                    raw = photo.urls.raw,
                    thumb = photo.urls.thumb,

                )
                )
            }
            emit(databasePhotos)

        } else {
            emit(databasePhotos)
        }
    }

    private suspend fun getPhotos () = apiService.getPhotos()

    private suspend fun addImage(imageItem: ImageItem){
        databaseDao.insert(imageItem)
    }
    suspend fun updateImageItem(imageItem: ImageItem){
        databaseDao.update(imageItem)
    }
    suspend fun deleteImages(imageItem: ImageItem){
        databaseDao.delete(imageItem)
    }
    suspend fun deleteAllImages (){
        databaseDao.deleteAllImageItems()
    }
}