package com.mn.seektest.home.domain

import com.mn.seektest.JobDetailsQuery
import com.mn.seektest.home.data.JobDetailsRemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class JobDetailsRepositoryImpl(
    private val jobDetailsRemoteDataSource: JobDetailsRemoteDataSource
) : JobDetailsRepository {

    override suspend fun getJobDetails(jobId: String): Flow<JobDetailsQuery.Job?> = flow {
        emit(jobDetailsRemoteDataSource.getJobDetails(jobId))
    }

    override suspend fun applyJob(jobId: String): Flow<Boolean> = flow {
        emit(jobDetailsRemoteDataSource.applyJob(jobId))
    }
}