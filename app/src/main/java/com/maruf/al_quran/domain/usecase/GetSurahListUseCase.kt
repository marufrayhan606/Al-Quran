package com.maruf.al_quran.domain.usecase

import com.maruf.al_quran.common.Resource
import com.maruf.al_quran.domain.model.Surah
import com.maruf.al_quran.domain.repository.QuranRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSurahListUseCase @Inject constructor(
    val repository: QuranRepository
) {
    operator fun invoke() : Flow<Resource<List<Surah>>> {
        return repository.getSurahList()

    }

}