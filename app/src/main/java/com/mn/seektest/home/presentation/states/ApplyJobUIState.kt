package com.mn.seektest.home.presentation.states

data class ApplyJobUIState(
    val isLoading: Boolean = false,
    val isSuccess: Boolean = false,
    val showError: Boolean = false,
)