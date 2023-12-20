package com.mn.seektest.home.pagination

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.mn.core.constants.SeekConstants.MY_JOBS_PAGE_SIZE
import com.mn.seektest.GetAllJobsQuery
import com.mn.seektest.home.data.MyJobsRemoteDataSource

class MyJobPagingSource(
    private val myJobsRemoteDataSource: MyJobsRemoteDataSource
) : PagingSource<Int, GetAllJobsQuery.Job>() {

    override fun getRefreshKey(state: PagingState<Int, GetAllJobsQuery.Job>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, GetAllJobsQuery.Job> {
        return try {
            val currentPage = params.key ?: 1
            val allJobs = myJobsRemoteDataSource.getMyJobs(currentPage, MY_JOBS_PAGE_SIZE)

            val jobs = allJobs?.jobs ?: emptyList()
            val myJobs = jobs.filterNotNull().filter {
                it.haveIApplied == true
            }

            LoadResult.Page(
                data = myJobs,
                prevKey = null,
                nextKey = if (myJobs.isEmpty()) null else (allJobs?.page!! + 1)
            )
        } catch (exception: Exception) {
            LoadResult.Error(exception)
        }
    }

}