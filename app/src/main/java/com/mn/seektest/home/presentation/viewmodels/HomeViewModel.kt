package com.mn.seektest.home.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.mn.seektest.home.presentation.states.HomeTabs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {

    private val _homeTabState = MutableStateFlow<HomeTabs>(HomeTabs.Jobs)
    val homeTabState = _homeTabState.asStateFlow()

    fun updateTabState(homeTab: HomeTabs) {
        _homeTabState.tryEmit(homeTab)
    }
}