package com.example.coins.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.coins.screens.ConverterScreen
import com.example.coins.screens.FiltersScreen
import com.example.coins.screens.HistoryScreen
import com.example.coins.screens.HomeScreen

fun NavGraphBuilder.homeGraph(navController: NavController) {
    navigation(startDestination = "homeMain", route = BottomBarScreen.Home.route) {
        composable(route = "homeMain") {
            HomeScreen(onNavigateToConverter = { navController.navigate(SubNavScreen.Converter.route) })
        }
        composable(route = SubNavScreen.Converter.route) {
            ConverterScreen(onNavigateToHome = { navController.navigate("homeMain") })
        }
    }
}

fun NavGraphBuilder.historyGraph(navController: NavController) {
    navigation(startDestination = "historyMain", route = BottomBarScreen.History.route) {
        composable(route = "historyMain") {
            HistoryScreen(onNavigateToFilters = { navController.navigate(SubNavScreen.Filters.route) })
        }
        composable(route = SubNavScreen.Filters.route) {
            FiltersScreen(onNavigateToHistory = { navController.navigate("historyMain") })
        }
    }
}