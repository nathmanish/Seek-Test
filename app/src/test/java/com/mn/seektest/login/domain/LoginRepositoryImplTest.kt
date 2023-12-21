package com.mn.seektest.login.domain

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.mn.seektest.login.data.LoginClient
import com.mn.seektest.login.data.LoginRequestModel
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class LoginRepositoryImplTest {
    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    private val loginClient = mock<LoginClient>()

    private val loginRepository = LoginRepositoryImpl(loginClient)

    @Test
    fun `when calling perform login, should call performLogin API`() {
        runTest {
            whenever(loginClient.performLogin(testLoginRequest)).thenReturn(
                testLoginResponse
            )
            loginRepository.performLogin(testLoginRequest)
            loginClient.performLogin(testLoginRequest)
            verify(loginClient).performLogin(testLoginRequest)
        }
    }
}

val testLoginRequest = LoginRequestModel(
    username = "testUser",
    password = "password"
)

private const val testLoginResponse = "success-auth-token"