package com.mn.seektest.home.domain

import com.mn.seektest.JobDetailsQuery
import kotlinx.coroutines.flow.Flow

interface JobDetailsRepository {
    suspend fun getJobDetails(jobId: String): Flow<JobDetailsQuery.Job?>

    suspend fun applyJob(jobId: String): Flow<Boolean>
}