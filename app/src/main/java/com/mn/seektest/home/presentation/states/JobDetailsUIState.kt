package com.mn.seektest.home.presentation.states

import com.mn.seektest.JobDetailsQuery

data class JobDetailsUIState(
    val isLoading: Boolean = false,
    val job: JobDetailsQuery.Job? = null,
    val showError: Boolean = false
)