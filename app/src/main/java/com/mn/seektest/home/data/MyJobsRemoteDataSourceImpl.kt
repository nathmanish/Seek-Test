package com.mn.seektest.home.data

import com.apollographql.apollo3.ApolloClient
import com.mn.seektest.GetAllJobsQuery

class MyJobsRemoteDataSourceImpl(
    private val apolloClient: ApolloClient
) : MyJobsRemoteDataSource {
    override suspend fun getMyJobs(page: Int, limit: Int): GetAllJobsQuery.Jobs? {
        try {
            val result = apolloClient.query(
                GetAllJobsQuery(
                    page = page,
                    limit = limit
                )
            ).execute()
            return result.data?.jobs
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }
}