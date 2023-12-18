package com.mn.seektest.login.presentation.activities

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.lifecycleScope
import com.mn.core.compose.SeekTestTheme
import com.mn.core.constants.SeekConstants.KEY_JWT_TOKEN
import com.mn.core.utils.SeekPreferencesHelper
import com.mn.seektest.R
import com.mn.seektest.login.data.LoginRequestModel
import com.mn.seektest.login.presentation.viewmodels.LoginViewModel
import com.mn.seektest.login.presentation.widgets.LoginListener
import com.mn.seektest.login.presentation.widgets.LoginScreen
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class LoginActivity : ComponentActivity(), LoginListener {

    private val loginViewModel: LoginViewModel by viewModels()

    @Inject
    lateinit var seekPreferencesHelper: SeekPreferencesHelper

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

        observeViewModel()
    }

    private fun observeViewModel() = with(lifecycleScope) {
        launch {
            loginViewModel.loginFlow.collectLatest {
                if (it.isSuccess) {
                    if (it.auth.isEmpty()) {
                        Toast.makeText(
                            this@LoginActivity,
                            getString(R.string.username_password_incorrect),
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        seekPreferencesHelper.putString(KEY_JWT_TOKEN, it.auth)
                    }
                }
            }
        }
    }

    override fun onLoginClicked(username: String, password: String) {
        if (username.trim().isEmpty() || password.trim().isEmpty()) {
            Toast.makeText(
                this@LoginActivity,
                getString(R.string.username_password_mandatory_msg),
                Toast.LENGTH_SHORT
            ).show()
            return
        }
        loginViewModel.performLogin(
            LoginRequestModel(username = username, password = password)
        )
    }
}