package com.mn.seektest.home.domain

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.mn.seektest.Query
import com.mn.seektest.home.data.ActiveJobsRemoteDataSourceImpl
import com.mn.seektest.home.pagination.ActiveJobPagingSource
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class ActiveJobsRepositoryImplTest {
    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    private val activeJobsRemoteDataSource = mock<ActiveJobsRemoteDataSourceImpl>()

    private val activeJobPagingSource = mock<ActiveJobPagingSource>()

    private val activeJobsRepository = ActiveJobsRepositoryImpl(activeJobPagingSource)

    @Test
    fun `getActiveJobs should call getActiveJobs() Api`() {
        runTest {
            whenever(activeJobsRemoteDataSource.getActiveJobs(any(), any()))
                .thenReturn(testQueryResult)

            activeJobPagingSource.load(any())
            activeJobsRepository.getActiveJobs()
            activeJobsRemoteDataSource.getActiveJobs(any(), any())
            verify(activeJobsRemoteDataSource).getActiveJobs(any(), any())
        }
    }


    private val testQueryResult = Query.Active(
        jobs = emptyList<Query.Job>(),
        page = 1,
        size = 10,
        total = 30,
        hasNext = true
    )
}