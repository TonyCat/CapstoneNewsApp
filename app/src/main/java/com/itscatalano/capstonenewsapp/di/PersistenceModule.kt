package com.itscatalano.capstonenewsapp.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
abstract class PersistenceModule {

    @Binds
    @Singleton
    abstract fun bindPreferencesHelper(preferencesHelperImpl: PreferencesHelperImpl): PreferencesHelper
}