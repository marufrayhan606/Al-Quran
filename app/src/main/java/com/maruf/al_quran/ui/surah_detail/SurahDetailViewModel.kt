package com.maruf.al_quran.ui.surah_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maruf.al_quran.common.Resource
import com.maruf.al_quran.domain.model.Ayah
import com.maruf.al_quran.domain.usecase.GetSurahDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

data class SurahDetailState(
    val isLoading: Boolean = false,
    val surahDetail: List<Ayah> = emptyList(),
    val error: String = ""
)

@HiltViewModel
class SurahDetailViewModel @Inject constructor(
    private val getSurahDetailUseCase: GetSurahDetailUseCase,
    savedStateHandle: SavedStateHandle
): ViewModel() {
    private val _state = mutableStateOf(SurahDetailState())
    val state: State<SurahDetailState> = _state

    init {
        savedStateHandle.get<Int>("surahNumber")?.let { surahNumber ->
            getSurahDetail(surahNumber)
        }
    }

    private fun getSurahDetail(surahNumber: Int){
        getSurahDetailUseCase(surahNumber).onEach {
            when(it){
                is Resource.Success -> {
                    _state.value = SurahDetailState(surahDetail = it.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = SurahDetailState(error = it.message ?: "Something went wrong")
                }
                is Resource.Loading -> {
                    _state.value = SurahDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

}