package com.maruf.al_quran.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.maruf.al_quran.ui.home.HomeScreen
import com.maruf.al_quran.ui.surah_detail.SurahDetailScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ){
        composable(route = Screen.Home.route) {
            HomeScreen(navController)
        }

        composable(
            route = Screen.SurahDetail.route + "/{surahNumber}",
            arguments = listOf(
                navArgument("surahNumber") {
                    type = NavType.IntType
                }
            )
        ) {
            val surahNumber = it.arguments?.getInt("surahNumber")
            if(surahNumber != null){
                SurahDetailScreen(surahNumber)
            }
        }

    }
}