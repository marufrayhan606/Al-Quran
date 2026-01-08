package com.maruf.al_quran.domain.usecase

import com.maruf.al_quran.common.Resource
import com.maruf.al_quran.domain.model.Ayah
import com.maruf.al_quran.domain.repository.QuranRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSurahDetailUseCase @Inject constructor(
    val repository: QuranRepository
) {
    operator fun invoke(surahNumber: Int): Flow<Resource<List<Ayah>>> {
        return repository.getSurahDetail(surahNumber)
    }
}