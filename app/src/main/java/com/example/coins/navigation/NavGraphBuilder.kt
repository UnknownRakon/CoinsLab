package com.example.coins.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.coins.screens.ConverterScreen
import com.example.coins.screens.HomeScreen

fun NavGraphBuilder.homeGraph(navController: NavController) {
    navigation(startDestination = "main", route = BottomBarScreen.Home.route) {
        composable(route = "main") {
            HomeScreen(onNavigateToConverter = { navController.navigate(SubNavScreen.Converter.route) })
        }
        composable(route = SubNavScreen.Converter.route) {
            ConverterScreen()
        }
    }
}