package com.mn.seektest.di

import com.apollographql.apollo3.ApolloClient
import com.mn.core.constants.SeekConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideApolloClient(): ApolloClient {
        return ApolloClient.Builder()
            .serverUrl(SeekConstants.SERVER_URL)
            .build()
    }

    @Provides
    fun provideIODispatcher() = Dispatchers.IO

    @Provides
    fun provideMainDispatcher() = Dispatchers.Main
}