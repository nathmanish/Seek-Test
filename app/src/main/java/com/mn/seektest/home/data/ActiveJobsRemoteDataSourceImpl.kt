package com.mn.seektest.home.data

import com.apollographql.apollo3.ApolloClient
import com.mn.seektest.Query

class ActiveJobsRemoteDataSourceImpl(
    private val apolloClient: ApolloClient
) : ActiveJobsRemoteDataSource {
    override suspend fun getActiveJobs(page: Int, limit: Int): Query.Active? {
        try {
            val result = apolloClient.query(
                Query(
                    page = page,
                    limit = limit
                )
            ).execute()
            return result.data?.active
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }
}