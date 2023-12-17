package com.mn.seektest.login.di

import com.apollographql.apollo3.ApolloClient
import com.mn.seektest.login.data.LoginClient
import com.mn.seektest.login.data.LoginClientImpl
import com.mn.seektest.login.domain.LoginRepository
import com.mn.seektest.login.domain.LoginRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object LoginModule {

    @Provides
    fun provideLoginRepository(loginClient: LoginClient): LoginRepository {
        return LoginRepositoryImpl(loginClient)
    }

    @Provides
    fun provideLoginClient(apolloClient: ApolloClient): LoginClient {
        return LoginClientImpl(apolloClient)
    }
}