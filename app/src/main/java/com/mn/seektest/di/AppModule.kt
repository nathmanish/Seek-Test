package com.mn.seektest.di

import android.content.Context
import com.apollographql.apollo3.ApolloClient
import com.mn.core.constants.SeekConstants
import com.mn.core.utils.SeekPreferencesHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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
    fun provideSeekPreferencesHelper(@ApplicationContext context: Context): SeekPreferencesHelper {
        return SeekPreferencesHelper(context)
    }

    @Provides
    fun provideIODispatcher() = Dispatchers.IO

    @Provides
    fun provideMainDispatcher() = Dispatchers.Main
}