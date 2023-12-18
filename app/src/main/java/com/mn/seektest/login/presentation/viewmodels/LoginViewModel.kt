package com.mn.seektest.login.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mn.seektest.login.data.LoginRequestModel
import com.mn.seektest.login.domain.LoginRepository
import com.mn.seektest.login.presentation.states.LoginUIState
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
class LoginViewModel @Inject constructor(
    private val loginRepository: LoginRepository,
    private val ioDispatcher: CoroutineDispatcher,
    private val mainDispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _loginFlow = MutableStateFlow(LoginUIState())
    val loginFlow = _loginFlow.asStateFlow()

    fun performLogin(loginRequestModel: LoginRequestModel) {
        _loginFlow.update { it.copy(isLoading = true, isSuccess = false) }
        viewModelScope.launch(ioDispatcher) {
            runCatching {
                loginRepository.performLogin(loginRequestModel).collectLatest { auth ->
                    withContext(mainDispatcher) {
                        _loginFlow.update {
                            it.copy(
                                isLoading = false,
                                auth = auth,
                                isSuccess = true,
                                showError = auth.isEmpty()
                            )
                        }
                    }
                }
            }
        }
    }
}