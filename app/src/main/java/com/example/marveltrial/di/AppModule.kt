package com.example.marveltrial.di

import com.example.marveltrial.common.Constants
import com.example.marveltrial.data.remote.MarvelAPI
import com.example.marveltrial.data.repository.MarvelAPIImpl
import com.example.marveltrial.domain.repository.MarvelRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideMarvelApi(): MarvelAPI {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MarvelAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideCharacterRepository(api: MarvelAPI): MarvelRepository {
        return MarvelAPIImpl(api)
    }
}
