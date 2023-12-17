package com.mn.seektest.login.domain

import com.mn.seektest.login.data.LoginClient
import com.mn.seektest.login.data.LoginRequestModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LoginRepositoryImpl(
    private val loginClient: LoginClient
) : LoginRepository {
    override fun performLogin(loginRequestModel: LoginRequestModel) = flow {
        emit(loginClient.performLogin(loginRequestModel))
    }

}