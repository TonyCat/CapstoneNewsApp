package com.itscatalano.capstonenewsapp.di

import dagger.Binds
import dagger.hilt.InstallIn
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindRemoteApi(remoteApiImpl: RemoteApiImpl): RemoteApi
}