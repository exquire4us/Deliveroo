package com.example.deliveroo.database

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule{
    @Singleton
    @Provides
    fun providesDatabaseDao(appDatabase: ImageDatabase) = appDatabase.imageItemDao()

    @Singleton
    @Provides
    fun providesDatabase(@ApplicationContext appContext: Context) = Room.databaseBuilder(
        appContext,
        ImageDatabase::class.java,
        "Unsplash_Photos_Database"
    )
        .fallbackToDestructiveMigration()
        .build()
}