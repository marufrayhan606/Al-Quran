package com.maruf.al_quran.ui.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maruf.al_quran.common.Resource
import com.maruf.al_quran.domain.usecase.GetSurahListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getSurahListUseCase: GetSurahListUseCase
): ViewModel() {
    private val _state = mutableStateOf(HomeState())
    val state: State<HomeState> = _state

    init{
        getSurahList()
    }

    private fun getSurahList(){
        getSurahListUseCase().onEach { result ->
            when(result){
                is Resource.Success -> {
                    _state.value = HomeState(surahList = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = HomeState(error = result.message ?: "Something went wrong")
                    }
                is Resource.Loading -> {
                    _state.value = HomeState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)

    }

}