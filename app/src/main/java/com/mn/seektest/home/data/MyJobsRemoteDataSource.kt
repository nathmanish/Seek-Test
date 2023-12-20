package com.mn.seektest.home.data

import com.mn.seektest.GetAllJobsQuery

interface MyJobsRemoteDataSource {
    suspend fun getMyJobs(page: Int, limit: Int): GetAllJobsQuery.Jobs?
}