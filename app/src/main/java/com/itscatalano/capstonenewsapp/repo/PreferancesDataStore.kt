package com.itscatalano.capstonenewsapp.repo

import kotlinx.coroutines.flow.Flow


interface PreferencesDataStore {
    fun isDownloadOverWifiOnly(): Flow<Boolean>
    suspend fun toggleDownloadOverWifiOnly()

}