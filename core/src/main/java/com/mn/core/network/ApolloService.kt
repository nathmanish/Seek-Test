package com.mn.core.network

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.network.okHttpClient
import com.mn.core.constants.SeekConstants
import com.mn.core.utils.SeekPreferencesHelper
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor

class ApolloService(
    private val serverURL: String,
    private val seekPreferencesHelper: SeekPreferencesHelper
) {
    private var accessToken: String? = null

    var apolloClient: ApolloClient =
        ApolloClient.Builder().serverUrl(serverURL).okHttpClient(buildOkHttp()).build()

    private fun buildOkHttp(): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = (HttpLoggingInterceptor.Level.BODY)
        return NetworkUtils.getHttpClientBuilder().addInterceptor { chain ->
            val result = getAccessToken()
            accessToken = result
            chain.proceed(chain.request().updateWithAuthHeader())
        }.addInterceptor(logging).build()
    }

    private fun Request.updateWithAuthHeader(): Request {
        val builder = this.newBuilder().method(this.method, this.body)
        val authHeader = "Bearer $accessToken"
        return builder.header("Authorization", authHeader).build()
    }

    private fun getAccessToken(): String? {
        return seekPreferencesHelper.getString(SeekConstants.KEY_JWT_TOKEN)
    }
}