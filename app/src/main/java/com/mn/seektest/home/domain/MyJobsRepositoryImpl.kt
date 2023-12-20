package com.mn.seektest.home.domain

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.mn.core.constants.SeekConstants
import com.mn.seektest.GetAllJobsQuery
import com.mn.seektest.home.pagination.MyJobPagingSource
import kotlinx.coroutines.flow.Flow

class MyJobsRepositoryImpl(
    private val myJobPagingSource: MyJobPagingSource
) : MyJobsRepository {

    override fun getMyJobs(): Flow<PagingData<GetAllJobsQuery.Job>> {
        return Pager(
            config = PagingConfig(
                pageSize = SeekConstants.MY_JOBS_PAGE_SIZE,
                prefetchDistance = 2
            ),
            pagingSourceFactory = {
                myJobPagingSource
            }
        ).flow
    }
}