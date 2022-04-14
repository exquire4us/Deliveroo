package com.example.deliveroo.repository

import com.example.deliveroo.database.*
import com.example.deliveroo.network.UnsplashApiServices
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UnsplashPhotosRepository @Inject constructor (
    private val databaseDao : DatabaseDao,
    private val apiService: UnsplashApiServices
        ) {
    val readAsianChefData  = flow<List<AsianChefPhotos>> {
        val databasePhotos = databaseDao.getAllChefPhotos()
        if (databasePhotos.isEmpty()){

            val apiPhotos = apiService.getChefPhotos()
            for (photo in apiPhotos){
                addChefPhoto(asianChefPhotos = AsianChefPhotos(
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

    val readAsianFoodData = flow<List<AsianFoodPhotos>>{
        val databasePhotos = databaseDao.getAllAsianFoodPhotos()
        if (databasePhotos.isEmpty()){

            val apiPhotos = apiService.getAsianFood()
            for (photo in apiPhotos){
                addAsianFoodPhoto(asianFood = AsianFoodPhotos(
                    imageId = photo.id,
                    description = photo.description,
                    full = photo.urls.regular,
                    )
                )
            }
            emit(databasePhotos)

        } else {
            emit(databasePhotos)
        }
    }

    val readAsianSnackData = flow<List<AsianSnackPhotos>>{
        val databasePhotos = databaseDao.getAllAsianSnackPhotos()
        if (databasePhotos.isEmpty()){

            val apiPhotos = apiService.getSnackPhotos()
            for (photo in apiPhotos){
                addAsianSnackPhoto(asianSnack = AsianSnackPhotos(
                    imageId = photo.id,
                    description = photo.description,
                    full = photo.urls.regular,
                )
                )
            }
            emit(databasePhotos)

        } else {
            emit(databasePhotos)
        }
    }

    val readAsianDessertData = flow<List<AsianDessertPhotos>> {
        val databasePhotos = databaseDao.getAllAsianDessertPhotos()
        if (databasePhotos.isEmpty()){

            val apiPhotos = apiService.getDessertPhotos()
            for (photo in apiPhotos){
                addAsianDessertPhoto(asianDessert = AsianDessertPhotos(
                    imageId = photo.id,
                    description = photo.description,
                    full = photo.urls.regular,
                )
                )
            }
            emit(databasePhotos)

        } else {
            emit(databasePhotos)
        }
    }

    val readAsianIceCreamData = flow<List<AsianIceCreamPhotos>> {
        val databasePhotos = databaseDao.getAllAsiaIceCreamPhotos()
        if (databasePhotos.isEmpty()){

            val apiPhotos = apiService.getIceCreamPhotos()
            for (photo in apiPhotos){
                addAsianIceCreamPhoto(asianIceCream = AsianIceCreamPhotos(
                    imageId = photo.id,
                    description = photo.description,
                    full = photo.urls.regular,
                )
                )
            }
            emit(databasePhotos)

        } else {
            emit(databasePhotos)
        }
    }


    private suspend fun addChefPhoto(asianChefPhotos: AsianChefPhotos){
        databaseDao.insertChefPhoto(asianChefPhotos)
    }

    private suspend fun addAsianFoodPhoto(asianFood: AsianFoodPhotos){
        databaseDao.insertAsianFoodPhoto(asianFood)
    }

    private suspend fun addAsianIceCreamPhoto(asianIceCream: AsianIceCreamPhotos){
        databaseDao.insertAsianIceCreamPhoto(asianIceCream)
    }

    private suspend fun addAsianSnackPhoto(asianSnack: AsianSnackPhotos){
        databaseDao.insertAsianSnackPhoto(asianSnack)
    }

    private suspend fun addAsianDessertPhoto(asianDessert:AsianDessertPhotos){
        databaseDao.insertAsianDessertPhoto(asianDessert)
    }

    suspend fun updateImageItem(asianChefPhotos: AsianChefPhotos){
        databaseDao.update(asianChefPhotos)
    }
    suspend fun deleteImages(asianChefPhotos: AsianChefPhotos){
        databaseDao.delete(asianChefPhotos)
    }
    suspend fun deleteAllImages (){
        databaseDao.deleteAllImageItems()
    }
}