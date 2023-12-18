package com.mn.seektest.login.data

import com.apollographql.apollo3.ApolloClient
import com.mn.seektest.Mutation

class LoginClientImpl(
    private val apolloClient: ApolloClient
) : LoginClient {

    override suspend fun performLogin(loginRequestModel: LoginRequestModel): String {
        try {
            return apolloClient.mutation(
                Mutation(
                    username = loginRequestModel.username,
                    password = loginRequestModel.password,
                )
            ).execute().data?.auth ?: ""
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return ""
    }
}