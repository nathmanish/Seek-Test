package com.mn.seektest.home.data

import com.mn.seektest.JobDetailsQuery

interface JobDetailsRemoteDataSource {
    suspend fun getJobDetails(jobId: String): JobDetailsQuery.Job?

    suspend fun applyJob(jobId: String): Boolean
}