package com.mn.seektest.login.data

interface LoginClient {
    suspend fun performLogin(loginRequestModel: LoginRequestModel): String
}