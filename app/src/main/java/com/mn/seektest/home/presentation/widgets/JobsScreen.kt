package com.mn.seektest.home.presentation.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshIndicator
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.mn.core.compose.backgroundSecondary
import com.mn.core.compose.blue
import com.mn.core.compose.views.SeekNoDataView
import com.mn.core.compose.views.SeekPageLoader
import com.mn.core.constants.SeekConstants
import com.mn.seektest.Query
import com.mn.seektest.R
import com.mn.seektest.home.navigation.HomeScreenNavigator
import com.mn.seektest.home.presentation.states.ActiveJobsUIState
import ir.kaaveh.sdpcompose.sdp

@Composable
fun JobsScreen(
    navigator: HomeScreenNavigator,
    activeJobsUIState: ActiveJobsUIState,
    jobScreenListener: JobScreenListener
) {

    val swipeRefreshState = rememberSwipeRefreshState(isRefreshing = activeJobsUIState.isLoading)

    SwipeRefresh(
        state = swipeRefreshState,
        indicator = { state, refreshTrigger ->
            SwipeRefreshIndicator(
                state = state,
                refreshTriggerDistance = refreshTrigger,
                contentColor = MaterialTheme.colorScheme.blue
            )
        },
        onRefresh = {
            jobScreenListener.onSwipeRefresh(SeekConstants.FROM_ACTIVE_JOBS)
        }) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.backgroundSecondary),
            contentAlignment = Alignment.Center
        ) {

            val jobItems: LazyPagingItems<Query.Job> =
                activeJobsUIState.data.collectAsLazyPagingItems()

            if (jobItems.itemCount == 0) {
                SeekNoDataView(
                    title = stringResource(id = R.string.no_active_jobs),
                    description = stringResource(
                        id = R.string.no_active_description
                    )
                )
            } else {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 20.sdp)
                ) {
                    items(jobItems.itemCount) { index ->
                        JobListItem(
                            navigator = navigator,
                            index = index,
                            job = jobItems[index]
                        )
                    }


                    jobItems.apply {
                        when {
                            loadState.append is LoadState.Loading -> {
                                item {
                                    SeekPageLoader(
                                        modifier = Modifier
                                            .padding(vertical = 10.sdp)
                                    )
                                }
                            }

                            loadState.refresh is LoadState.Error -> {
                                jobScreenListener.onLoadError()
                            }

                            loadState.append is LoadState.Error -> {
                                jobScreenListener.onLoadError()
                            }
                        }
                    }
                }
            }
        }
    }
}

interface JobScreenListener {
    fun onSwipeRefresh(from: String)
    fun onLoadError()
}