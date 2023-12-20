package com.mn.seektest.login.presentation.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.mn.core.compose.brandBlue
import com.mn.core.compose.button
import com.mn.core.compose.caption2
import com.mn.core.compose.textPrimary
import com.mn.core.compose.textSecondary
import com.mn.core.compose.title2
import com.mn.core.compose.title5
import com.mn.core.compose.title6
import com.mn.core.compose.views.BlueButton
import com.mn.core.compose.views.SeekLoader
import com.mn.core.extensions.noRippleClickable
import com.mn.seektest.R
import com.mn.seektest.login.presentation.states.LoginUIState
import ir.kaaveh.sdpcompose.sdp

@Composable
fun LoginScreen(
    loginUIState: LoginUIState,
    loginListener: LoginListener?
) {

    var emailAddress by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    var isPasswordVisible by remember {
        mutableStateOf(false)
    }

    Scaffold {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
        ) {
            Column(
                modifier = Modifier.padding(16.sdp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 40.sdp)
                        .verticalScroll(rememberScrollState()),
                    contentAlignment = Alignment.Center,
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.seek_logo_big),
                        contentDescription = "seek-logo",
                    )
                }
                Text(
                    modifier = Modifier.padding(top = 20.sdp),
                    text = stringResource(id = R.string.sign_in),
                    color = MaterialTheme.colorScheme.textPrimary,
                    style = MaterialTheme.typography.title2
                )
                Text(
                    modifier = Modifier.padding(top = 20.sdp),
                    text = stringResource(id = R.string.email_address),
                    color = MaterialTheme.colorScheme.textPrimary,
                    style = MaterialTheme.typography.title5
                )
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 3.sdp),
                    value = emailAddress,
                    onValueChange = {
                        emailAddress = it
                    },
                    singleLine = true,
                    label = {
                        Text(
                            text = stringResource(id = R.string.enter_email_address),
                            color = MaterialTheme.colorScheme.textSecondary,
                            style = MaterialTheme.typography.caption2
                        )
                    },
                )
                Row(
                    modifier = Modifier.padding(top = 10.sdp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier.weight(1f),
                        text = stringResource(id = R.string.password),
                        color = MaterialTheme.colorScheme.textPrimary,
                        style = MaterialTheme.typography.title5
                    )
                    Text(
                        modifier = Modifier.padding(start = 5.sdp),
                        text = stringResource(id = R.string.forgot_password),
                        color = MaterialTheme.colorScheme.button,
                        style = MaterialTheme.typography.button
                    )
                }
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 3.sdp),
                    value = password,
                    onValueChange = {
                        password = it
                    },
                    singleLine = true,
                    visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        Icon(
                            modifier = Modifier.noRippleClickable {
                                isPasswordVisible = !isPasswordVisible
                            },
                            painter = painterResource(id = R.drawable.ic_eye),
                            contentDescription = "show-password-icon",
                            tint = if(isPasswordVisible) MaterialTheme.colorScheme.brandBlue else MaterialTheme.colorScheme.textSecondary
                        )
                    },
                    label = {
                        Text(
                            text = stringResource(id = R.string.enter_password),
                            color = MaterialTheme.colorScheme.textSecondary,
                            style = MaterialTheme.typography.caption2
                        )
                    },
                )
                BlueButton(
                    modifier = Modifier
                        .padding(top = 20.sdp)
                        .fillMaxWidth(),
                    boxModifier = Modifier.fillMaxWidth(),
                    text = stringResource(id = R.string.sign_in)
                ) {
                    loginListener?.onLoginClicked(username = emailAddress, password = password)
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.sdp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = stringResource(id = R.string.no_account),
                        color = MaterialTheme.colorScheme.textPrimary,
                        style = MaterialTheme.typography.title6
                    )
                    Text(
                        modifier = Modifier.padding(start = 5.sdp),
                        text = stringResource(id = R.string.register_now),
                        color = MaterialTheme.colorScheme.button,
                        style = MaterialTheme.typography.button
                    )
                }
            }

            if (loginUIState.isLoading) {
                SeekLoader()
            }
        }
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen(
        loginUIState = LoginUIState(),
        loginListener = null
    )
}

interface LoginListener {
    fun onLoginClicked(username: String, password: String)
}