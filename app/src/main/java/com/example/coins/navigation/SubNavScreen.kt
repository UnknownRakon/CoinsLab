package com.example.coins.navigation

import com.example.coins.R

sealed class SubNavScreen(
    val route: String,
    val title: String,
) {

    object Converter : SubNavScreen(
        route = "converter",
        title = "converter",
    )
}