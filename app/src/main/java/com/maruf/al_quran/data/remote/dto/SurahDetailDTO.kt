package com.maruf.al_quran.data.remote.dto

import com.maruf.al_quran.ui.navigation.Screen

data class AyahDTO(
    val audio: String? = null,
//    val audioSecondary: List<String>,
//    val hizbQuarter: Int,
//    val juz: Int,
//    val manzil: Int,
    val number: Int,
    val numberInSurah: Int,
//    val page: Int,
//    val ruku: Int,
//    val sajda: Boolean,
    val text: String
)
data class EditionDTO(
    val direction: String,
    val englishName: String,
    val format: String,
    val identifier: String,
    val language: String,
    val name: String,
    val type: String
)
data class SurahDetailDTO(
    val ayahs: List<AyahDTO>,
    val edition: EditionDTO,
    val englishName: String,
    val englishNameTranslation: String,
    val name: String,
    val number: Int,
    val numberOfAyahs: Int,
    val revelationType: String
)