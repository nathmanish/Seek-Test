package com.mn.seektest.home.presentation.states

import androidx.paging.PagingData
import com.mn.seektest.GetAllJobsQuery
import kotlinx.coroutines.flow.MutableStateFlow

data class MyJobsUIState(
    val isLoading: Boolean = false,
    val data: MutableStateFlow<PagingData<GetAllJobsQuery.Job>> = MutableStateFlow(PagingData.empty()),
)