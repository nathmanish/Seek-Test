package com.mn.seektest.home.di

import com.apollographql.apollo3.ApolloClient
import com.mn.seektest.home.data.ActiveJobsRemoteDataSource
import com.mn.seektest.home.data.ActiveJobsRemoteDataSourceImpl
import com.mn.seektest.home.domain.ActiveJobsRepository
import com.mn.seektest.home.domain.ActiveJobsRepositoryImpl
import com.mn.seektest.home.pagination.ActiveJobPagingSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object ActiveJobsModule {

    @Provides
    fun provideActiveJobsRemoteDataSource(apolloClient: ApolloClient): ActiveJobsRemoteDataSource =
        ActiveJobsRemoteDataSourceImpl(apolloClient)

    @Provides
    fun provideActiveJobsPagingSource(activeJobsRemoteDataSource: ActiveJobsRemoteDataSource): ActiveJobPagingSource =
        ActiveJobPagingSource(activeJobsRemoteDataSource)

    @Provides
    fun provideActiveJobsRepository(activeJobsPagingSource: ActiveJobPagingSource): ActiveJobsRepository =
        ActiveJobsRepositoryImpl(activeJobsPagingSource)
}