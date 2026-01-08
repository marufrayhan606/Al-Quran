package com.maruf.al_quran.data.remote.dto

data class APIResponse<T>(
    val code: Int,
    val data: T,
    val status: String
)