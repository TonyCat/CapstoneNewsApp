package com.itscatalano.capstonenewsapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Converter
import retrofit2.Retrofit


@Module
@InstallIn(ApplicationComponent::class)
object NetworkingModule {

    private const val HEADER_AUTHORIZATION = "Authorization"
    private const val BASE_URL = "https://taskie-rw.herokuapp.com"

    @Provides
    fun provideFactory(): Converter.Factory {
        val contentType = "application/json".toMediaType()

        return Json.nonstrict.asConverterFactory(contentType)
    }

    @Provides
    fun provideAuthorizationInterceptor(preferencesHelper: PreferencesHelper) = object :
        Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val originalRequest = chain.request()

            if (preferencesHelper.getToken().isBlank()) return chain.proceed(originalRequest)

            val new = originalRequest.newBuilder()
                .addHeader(HEADER_AUTHORIZATION, preferencesHelper.getToken())
                .build()

            return chain.proceed(new)
        }
    }

    @Provides
    fun provideClient(interceptor: Interceptor): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .addInterceptor(interceptor)
            .build()


    @Provides
    fun buildRetrofit(client: OkHttpClient, factory: Converter.Factory): Retrofit {
        return Retrofit.Builder()
            .client(client)
            .baseUrl(BASE_URL)
            .addConverterFactory(factory)
            .build()
    }

    @Provides
    fun buildApiService(retrofit: Retrofit): RemoteApiService =
        retrofit.create(RemoteApiService::class.java)
}