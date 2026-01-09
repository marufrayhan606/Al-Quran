package com.maruf.al_quran.di

import android.content.Context
import com.maruf.al_quran.common.Constants.BASE_URL
import com.maruf.al_quran.data.remote.QuranAPI
import com.maruf.al_quran.data.repository.QuranRepositoryImpl
import com.maruf.al_quran.domain.repository.QuranRepository
import com.maruf.al_quran.ui.util.AudioPlayer
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideQuranAPI(): QuranAPI {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(QuranAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideQuranRepository(api: QuranAPI): QuranRepository {
        return QuranRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideAudioPlayer(@ApplicationContext context: Context): AudioPlayer {
        return AudioPlayer(context = context)
    }
}
