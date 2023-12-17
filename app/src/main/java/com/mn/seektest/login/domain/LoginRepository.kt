package com.mn.seektest.login.domain

import com.mn.seektest.login.data.LoginRequestModel
import kotlinx.coroutines.flow.Flow

interface LoginRepository {
    fun performLogin(loginRequestModel: LoginRequestModel): Flow<String>
}