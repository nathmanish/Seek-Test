package com.mn.seektest.home.presentation.states

sealed class ApplyJobUIEvent {
    data class ReloadJob(val jobId: String) : ApplyJobUIEvent()
    data object OnError : ApplyJobUIEvent()
}