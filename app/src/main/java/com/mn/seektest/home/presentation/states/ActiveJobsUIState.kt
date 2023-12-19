package com.mn.seektest.home.presentation.states

import androidx.paging.PagingData
import com.mn.seektest.Query
import kotlinx.coroutines.flow.MutableStateFlow

data class ActiveJobsUIState(
    val isLoading: Boolean = false,
    val data: MutableStateFlow<PagingData<Query.Job>> = MutableStateFlow(PagingData.empty())
)