package com.mn.seektest.home.pagination

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.mn.core.constants.SeekConstants.ACTIVE_JOBS_PAGE_SIZE
import com.mn.seektest.Query
import com.mn.seektest.home.data.ActiveJobsRemoteDataSource
import java.io.IOException

class ActiveJobPagingSource(
    private val activeJobsRemoteDataSource: ActiveJobsRemoteDataSource
) : PagingSource<Int, Query.Job>() {

    override fun getRefreshKey(state: PagingState<Int, Query.Job>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Query.Job> {
        try {
            val currentPage = params.key ?: 1
            val active =
                activeJobsRemoteDataSource.getActiveJobs(currentPage, ACTIVE_JOBS_PAGE_SIZE)

            val activeJobs = active?.jobs ?: emptyList()
            val jobs = activeJobs.filterNotNull()

            return LoadResult.Page(
                data = jobs,
                prevKey = null,
                nextKey = if (jobs.isEmpty()) null else active?.page!! + 1
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        }
    }

}