package com.mn.seektest.home.di

import com.apollographql.apollo3.ApolloClient
import com.mn.seektest.home.data.MyJobsRemoteDataSource
import com.mn.seektest.home.data.MyJobsRemoteDataSourceImpl
import com.mn.seektest.home.domain.MyJobsRepository
import com.mn.seektest.home.domain.MyJobsRepositoryImpl
import com.mn.seektest.home.pagination.MyJobPagingSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object MyJobsModule {

    @Provides
    fun provideMyJobsRemoteDataSource(apolloClient: ApolloClient): MyJobsRemoteDataSource =
        MyJobsRemoteDataSourceImpl(apolloClient)

    @Provides
    fun provideMyJobsPagingSource(myJobsRemoteDataSource: MyJobsRemoteDataSource): MyJobPagingSource =
        MyJobPagingSource(myJobsRemoteDataSource)

    @Provides
    fun provideMyJobsRepository(myJobsPagingSource: MyJobPagingSource): MyJobsRepository =
        MyJobsRepositoryImpl(myJobsPagingSource)
}