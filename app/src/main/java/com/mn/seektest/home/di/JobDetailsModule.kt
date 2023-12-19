package com.mn.seektest.home.di

import com.apollographql.apollo3.ApolloClient
import com.mn.seektest.home.data.JobDetailsRemoteDataSource
import com.mn.seektest.home.data.JobDetailsRemoteDataSourceImpl
import com.mn.seektest.home.domain.JobDetailsRepository
import com.mn.seektest.home.domain.JobDetailsRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object JobDetailsModule {

    @Provides
    fun provideJobDetailsRemoteDataSource(apolloClient: ApolloClient): JobDetailsRemoteDataSource =
        JobDetailsRemoteDataSourceImpl(apolloClient)

    @Provides
    fun provideJobDetailsRepository(jobDetailsRemoteDataSource: JobDetailsRemoteDataSource): JobDetailsRepository =
        JobDetailsRepositoryImpl(jobDetailsRemoteDataSource)
}