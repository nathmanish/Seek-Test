package com.mn.seektest.home.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.mn.seektest.home.domain.MyJobsRepository
import com.mn.seektest.home.presentation.states.MyJobsUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MyJobsViewModel @Inject constructor(
    private val myJobsRepository: MyJobsRepository,
    private val ioDispatcher: CoroutineDispatcher,
    private val mainDispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _myJobsUIState = MutableStateFlow(MyJobsUIState())
    val myJobsUIState = _myJobsUIState.asStateFlow()

    init {
        getMyJobs()
    }

    fun getMyJobs() {
        _myJobsUIState.update { it.copy(isLoading = true) }
        viewModelScope.launch(ioDispatcher) {
            runCatching {
                myJobsRepository.getMyJobs().cachedIn(viewModelScope).collectLatest { pagingData ->
                    withContext(mainDispatcher) {
                        _myJobsUIState.update {
                            it.copy(
                                isLoading = false,
                                data = MutableStateFlow(pagingData),
                            )
                        }
                    }
                }
            }
        }
    }
}