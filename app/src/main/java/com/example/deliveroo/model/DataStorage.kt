package com.example.deliveroo.model

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class StoreUserDetails(private val context: Context ) {
    companion object {
        private val Context.dataStore : DataStore<Preferences> by preferencesDataStore(name = "Userdata ")
        private val USER_KEY = stringPreferencesKey("userdata")

    }
    val getUserData : Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[USER_KEY] ?: ""
        }
     suspend fun StoreUserData(userDetails: String) {
        context.dataStore.edit {preferences ->
            preferences[USER_KEY] = userDetails
        }
    }
}