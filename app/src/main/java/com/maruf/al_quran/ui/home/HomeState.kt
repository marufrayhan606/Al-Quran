package com.maruf.al_quran.ui.home

import com.maruf.al_quran.domain.model.Surah

data class HomeState (
    val isLoading: Boolean = false,
    val surahList: List<Surah> = emptyList(),
    val error: String = ""
)
