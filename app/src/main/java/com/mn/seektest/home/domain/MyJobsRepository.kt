package com.mn.seektest.home.domain

import androidx.paging.PagingData
import com.mn.seektest.GetAllJobsQuery
import kotlinx.coroutines.flow.Flow

interface MyJobsRepository {
    fun getMyJobs(): Flow<PagingData<GetAllJobsQuery.Job>>
}