package com.example.coins.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.coins.screens.HistoryScreen
import com.example.coins.screens.HomeScreen
import com.example.coins.screens.StatisticsScreen


@Composable
fun BottomNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route,
    ) {
        homeGraph(navController)
        historyGraph(navController)
        composable(route = BottomBarScreen.Statistics.route) {
            StatisticsScreen()
        }
    }
}
