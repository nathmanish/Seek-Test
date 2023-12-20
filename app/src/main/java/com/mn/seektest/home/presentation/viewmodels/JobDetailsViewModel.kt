package com.mn.seektest.home.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mn.core.extensions.mutableSharedFlow
import com.mn.seektest.home.domain.JobDetailsRepository
import com.mn.seektest.home.presentation.states.ApplyJobUIEvent
import com.mn.seektest.home.presentation.states.ApplyJobUIState
import com.mn.seektest.home.presentation.states.JobDetailsUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class JobDetailsViewModel @Inject constructor(
    private val jobDetailsRepository: JobDetailsRepository,
    private val ioDispatcher: CoroutineDispatcher,
    private val mainDispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _jobDetailsUIState = MutableStateFlow(JobDetailsUIState())
    val jobDetailsUIState = _jobDetailsUIState.asStateFlow()

    private val _applyJobUIState = MutableStateFlow(ApplyJobUIState())
    val applyJobUIState = _applyJobUIState.asStateFlow()

    private val _applyJobUIEvent = mutableSharedFlow<ApplyJobUIEvent>(extraBufferCapacity = 1)
    val applyJobUIEvent = _applyJobUIEvent.asSharedFlow()

    fun getJobDetails(jobId: String) {
        _jobDetailsUIState.update {
            it.copy(isLoading = true)
        }
        viewModelScope.launch(ioDispatcher) {
            runCatching {
                jobDetailsRepository.getJobDetails(jobId).collectLatest { job ->
                    withContext(mainDispatcher) {
                        _jobDetailsUIState.update {
                            it.copy(
                                isLoading = false,
                                job = job,
                                showError = job != null
                            )
                        }
                    }
                }
            }
        }
    }

    fun applyJob(jobId: String) {
        _applyJobUIState.update {
            it.copy(
                isLoading = true,
                isSuccess = false,
                showError = false
            )
        }
        viewModelScope.launch(ioDispatcher) {
            runCatching {
                jobDetailsRepository.applyJob(jobId).collectLatest { isSuccess ->
                    withContext(mainDispatcher) {
                        _applyJobUIState.update {
                            it.copy(
                                isLoading = false,
                                isSuccess = isSuccess,
                                showError = !isSuccess,
                            )
                        }
                        if (isSuccess) {
                            updateApplyJobUIEvent(ApplyJobUIEvent.ReloadJob(jobId))
                        } else {
                            updateApplyJobUIEvent(ApplyJobUIEvent.OnError)
                        }
                    }
                }
            }
        }
    }

    private fun updateApplyJobUIEvent(event: ApplyJobUIEvent) {
        _applyJobUIEvent.tryEmit(event)
    }
}