package com.example.deliveroo.database

import androidx.lifecycle.LiveData

class ImageListRepo(private val imageItemDao : ImageItemDao) {
    val readData : LiveData<List<ImageItem>> = imageItemDao.getAllPhotos()
    suspend fun addImage(imageItem: ImageItem){
        imageItemDao.insert(imageItem)
    }
    suspend fun updateImageItem(imageItem: ImageItem){
        imageItemDao.update(imageItem)
    }
    suspend fun deleteImages(imageItem: ImageItem){
        imageItemDao.delete(imageItem)
    }
    suspend fun deleteAllImages (){
        imageItemDao.deleteAllImageItems()
    }
}