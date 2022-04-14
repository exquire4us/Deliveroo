package com.example.deliveroo.model

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.deliveroo.database.*
import com.example.deliveroo.repository.UnsplashPhotosRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class MyPhotosViewModel @Inject constructor(
    private val unsplashRepository: UnsplashPhotosRepository
) : ViewModel() {
    val chefPhotos = mutableStateOf(listOf<AsianChefPhotos>())
    val foodPhotos = mutableStateOf(listOf<AsianFoodPhotos>())
    val iceCreamPhotos= mutableStateOf(listOf<AsianIceCreamPhotos>())
    val snackPhotos = mutableStateOf(listOf<AsianSnackPhotos>())
    val dessertPhotos = mutableStateOf(listOf<AsianDessertPhotos>())
    val selectedButton = mutableStateOf(categoriesList.first())

    init {
        loadPhotos()
    }

    private fun loadPhotos(){

        viewModelScope.launch(Dispatchers.IO) {
            unsplashRepository.readAsianChefData.collect{ images ->
               withContext(Dispatchers.Main) {
                   chefPhotos.value = images
               }

            }
            unsplashRepository.readAsianFoodData.collect{food->
                withContext(Dispatchers.Main){
                    foodPhotos.value = food
                }

            }
            unsplashRepository.readAsianSnackData.collect{snacks ->
                withContext(Dispatchers.Main){
                    snackPhotos.value = snacks
                }

            }
            unsplashRepository.readAsianDessertData.collect{desserts ->
                withContext(Dispatchers.Main){
                    dessertPhotos.value = desserts
                }
            }

            unsplashRepository.readAsianIceCreamData.collect{iceCream->
                withContext(Dispatchers.Main){
                    iceCreamPhotos.value = iceCream
                }
            }

        }
    }
}