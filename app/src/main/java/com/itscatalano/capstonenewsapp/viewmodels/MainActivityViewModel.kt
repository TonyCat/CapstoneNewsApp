package com.itscatalano.capstonenewsapp.viewmodels

import androidx.lifecycle.*
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.CreationExtras
import com.itscatalano.capstonenewsapp.App
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch



class MainActivityViewModel : ViewModel() {
    class Factory : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return MainActivityViewModel() as T
        }
    }

    val isDownloadOverWifiOnly = App.prefsDataStore.isDownloadOverWifiOnly().asLiveData()

    fun toggleDownloadOverWifiOnly() {
        viewModelScope.launch(Dispatchers.IO) {
            App.prefsDataStore.toggleDownloadOverWifiOnly()
        }
    }

}