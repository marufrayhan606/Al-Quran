package com.maruf.al_quran.data.remote.dto

import com.maruf.al_quran.domain.model.Surah

data class SurahDTO(
    val englishName: String,
    val englishNameTranslation: String,
    val name: String,
    val number: Int,
    val numberOfAyahs: Int,
    val revelationType: String
)

fun SurahDTO.toDomainSurah(): Surah {
    return Surah(
        number = number,
        name = name,
        englishName = englishName,
        englishNameTranslation = englishNameTranslation,
        numberOfAyahs = numberOfAyahs,
        revelationType = revelationType
    )
}