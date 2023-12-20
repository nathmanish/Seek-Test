package com.mn.core.network

import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

object NetworkUtils {

    fun getHttpClientBuilder(): OkHttpClient.Builder {
        return OkHttpClient.Builder()
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .writeTimeout(120, TimeUnit.SECONDS)
    }
}