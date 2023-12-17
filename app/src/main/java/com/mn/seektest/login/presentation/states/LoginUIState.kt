package com.mn.seektest.login.presentation.states

data class LoginUIState(
    val isLoading: Boolean = false,
    val auth: String = "",
    val showError: Boolean = false
)