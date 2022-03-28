package com.example.deliveroo.model

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.deliveroo.database.ImageItem
import com.example.deliveroo.repository.UnsplashPhotosRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MyPhotosViewModel @Inject constructor(
    private val unsplashRepository: UnsplashPhotosRepository
) : ViewModel() {
     val databasePhotos = mutableStateOf(listOf<ImageItem>())

    init {
        loadPhotos()
    }

    private fun loadPhotos(){

        viewModelScope.launch(Dispatchers.IO) {
            unsplashRepository.readData.collect{ image ->
                databasePhotos.value = image

            }
        }
    }
}