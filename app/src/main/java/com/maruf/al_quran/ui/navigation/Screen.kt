package com.maruf.al_quran.ui.navigation

import android.R

sealed class Screen(val route: String) {
    object Home : Screen("home_screen")
    object SurahDetail : Screen("surah_detail_screen")

    fun withArgs(vararg args: Any): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}