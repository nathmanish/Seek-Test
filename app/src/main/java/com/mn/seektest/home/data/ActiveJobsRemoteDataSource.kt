package com.mn.seektest.home.data

import com.mn.seektest.Query

interface ActiveJobsRemoteDataSource {
    suspend fun getActiveJobs(page: Int, limit: Int): Query.Active?
}