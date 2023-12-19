package com.mn.seektest.home.domain

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.mn.core.constants.SeekConstants
import com.mn.seektest.Query
import com.mn.seektest.home.pagination.ActiveJobPagingSource
import kotlinx.coroutines.flow.Flow

class ActiveJobsRepositoryImpl(
    private val activeJobPagingSource: ActiveJobPagingSource
) : ActiveJobsRepository {

    override suspend fun getActiveJobs(): Flow<PagingData<Query.Job>> {
        return Pager(
            config = PagingConfig(
                pageSize = SeekConstants.ACTIVE_JOBS_PAGE_SIZE,
                prefetchDistance = 2
            ),
            pagingSourceFactory = {
                activeJobPagingSource
            }
        ).flow
    }


}