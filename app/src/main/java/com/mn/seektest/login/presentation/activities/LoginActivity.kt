package com.mn.seektest.login.presentation.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.mn.core.compose.SeekTestTheme
import com.mn.seektest.login.presentation.widgets.LoginScreen

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SeekTestTheme {
                LoginScreen()
            }
        }
    }
}