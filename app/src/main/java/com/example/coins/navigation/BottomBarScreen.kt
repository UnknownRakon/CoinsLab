package com.example.coins.navigation

import com.example.coins.R


sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: Int,
    val icon_focused: Int
) {

    object Home : BottomBarScreen(
        route = "home",
        title = "Обмен",
        icon = R.drawable.home,
        icon_focused = R.drawable.home_focused
    )

    object History : BottomBarScreen(
        route = "history",
        title = "История",
        icon = R.drawable.history,
        icon_focused = R.drawable.history_focused
    )

    object Statistics : BottomBarScreen(
        route = "statistics",
        title = "Аналитика",
        icon = R.drawable.statistics,
        icon_focused = R.drawable.statistics_focused
    )

}


