package com.maruf.al_quran.data.repository

import com.maruf.al_quran.common.Resource
import com.maruf.al_quran.data.remote.QuranAPI
import com.maruf.al_quran.data.remote.dto.toDomainSurah
import com.maruf.al_quran.domain.model.Ayah
import com.maruf.al_quran.domain.model.Surah
import com.maruf.al_quran.domain.repository.QuranRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class QuranRepositoryImpl @Inject constructor(
    private val api: QuranAPI
): QuranRepository {
    override fun getSurahList(): Flow<Resource<List<Surah>>>{
        return flow {
            try {
                emit(Resource.Loading())

                val response = api.getSurahList()

                val surahList = response.data.map { it.toDomainSurah() }
                emit(Resource.Success(surahList))

            }catch (e: HttpException){
                emit(Resource.Error(e.message ?: "Something went wrong"))

            }catch (e: IOException){
                emit(Resource.Error(e.message ?: "Couldn't reach server. Check your internet connection"))

            }
        }
    }

    override fun getSurahDetail(surahNumber: Int): Flow<Resource<List<Ayah>>> {
        return flow {
            try {
                emit(Resource.Loading())

                val response = api.getSurahDetail(surahNumber)

                if(response.data.size < 2) {
                    emit(Resource.Error("Translation or Arabic not found"))
                    return@flow
                }

                val arabicList = response.data[0].ayahs
                val translationList = response.data[1].ayahs

                val resultList = mutableListOf<Ayah>()

                for(i in arabicList.indices){
                    resultList.add(
                        Ayah(
                            number = arabicList[i].number,
                            text = arabicList[i].text,
                            translation = translationList[i].text,
                            audio = arabicList[i].audio ?: ""
                        )
                    )
                }

                emit(Resource.Success(resultList))
            }
            catch (e :Exception){
                e.printStackTrace()
                emit(Resource.Error(e.message ?: "Something went wrong"))
            }
        }
    }
}