package com.mn.seektest.login.presentation.states

data class LoginUIState(
    val isLoading: Boolean = false,
    val auth: String = "",
    val isSuccess: Boolean = false,
    val showError: Boolean = false
)