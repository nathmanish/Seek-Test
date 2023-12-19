package com.mn.seektest.home.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.mn.seektest.home.domain.ActiveJobsRepository
import com.mn.seektest.home.presentation.states.ActiveJobsUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ActiveJobsViewModel @Inject constructor(
    private val activeJobsRepository: ActiveJobsRepository,
    private val ioDispatcher: CoroutineDispatcher,
    private val mainDispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _activeJobs = MutableStateFlow(ActiveJobsUIState())
    val activeJobs = _activeJobs.asStateFlow()

    init {
        getActiveJobs()
    }

    fun getActiveJobs() {
        _activeJobs.update { it.copy(isLoading = true) }
        viewModelScope.launch(ioDispatcher) {
            activeJobsRepository.getActiveJobs().cachedIn(viewModelScope).collect { pagingData ->
                withContext(mainDispatcher) {
                    _activeJobs.update {
                        it.copy(
                            isLoading = false,
                            data = MutableStateFlow(pagingData)
                        )
                    }
                }
            }
        }
    }
}