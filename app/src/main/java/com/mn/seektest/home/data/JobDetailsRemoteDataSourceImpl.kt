package com.mn.seektest.home.data

import com.apollographql.apollo3.ApolloClient
import com.mn.seektest.ApplyJobMutation
import com.mn.seektest.JobDetailsQuery

class JobDetailsRemoteDataSourceImpl(
    private val apolloClient: ApolloClient
) : JobDetailsRemoteDataSource {

    override suspend fun getJobDetails(jobId: String): JobDetailsQuery.Job? {
        try {
            val result = apolloClient.query(
                JobDetailsQuery(
                    jobId = jobId
                )
            ).execute()
            return result.data?.job
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }

    override suspend fun applyJob(jobId: String): Boolean {
        try {
            val result = apolloClient.mutation(
                ApplyJobMutation(
                    jobId = jobId
                )
            ).execute()
            return result.data?.apply ?: false
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return false
    }
}