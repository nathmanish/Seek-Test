package com.mn.seektest.home.domain

import androidx.paging.PagingData
import com.mn.seektest.Query
import kotlinx.coroutines.flow.Flow

interface ActiveJobsRepository {
    suspend fun getActiveJobs(): Flow<PagingData<Query.Job>>
}