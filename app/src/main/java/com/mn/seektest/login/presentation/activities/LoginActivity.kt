package com.mn.seektest.login.presentation.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.mn.core.compose.SeekTestTheme
import com.mn.seektest.login.data.LoginRequestModel
import com.mn.seektest.login.presentation.viewmodels.LoginViewModel
import com.mn.seektest.login.presentation.widgets.LoginListener
import com.mn.seektest.login.presentation.widgets.LoginScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : ComponentActivity(), LoginListener {
    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val loginUIState by loginViewModel.loginFlow.collectAsState()

            SeekTestTheme {
                LoginScreen(
                    loginUIState = loginUIState,
                    loginListener = this
                )
            }
        }
    }

    override fun onLoginClicked(username: String, password: String) {
        loginViewModel.performLogin(
            LoginRequestModel(username = username, password = password)
        )
    }
}