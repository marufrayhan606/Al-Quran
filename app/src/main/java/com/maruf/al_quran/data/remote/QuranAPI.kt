package com.maruf.al_quran.data.remote

import com.maruf.al_quran.data.remote.dto.APIResponse
import com.maruf.al_quran.data.remote.dto.SurahDTO
import com.maruf.al_quran.data.remote.dto.SurahDetailDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface QuranAPI {
    @GET("surah")
    suspend fun getSurahList(): APIResponse<List<SurahDTO>>

    @GET("surah/{number}/editions/ar.alafasy,bn.bengali")
    suspend fun getSurahDetail(@Path("number") surahNumber: Int): APIResponse<List<SurahDetailDTO>>


}
