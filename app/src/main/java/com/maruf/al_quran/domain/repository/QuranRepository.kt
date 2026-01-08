package com.maruf.al_quran.domain.repository

import com.maruf.al_quran.common.Resource
import com.maruf.al_quran.domain.model.Ayah
import com.maruf.al_quran.domain.model.Surah
import kotlinx.coroutines.flow.Flow

interface QuranRepository {
    fun getSurahList(): Flow<Resource<List<Surah>>>

    fun getSurahDetail(surahNumber: Int): Flow<Resource<List<Ayah>>>

}