package com.bangpq.balancewatcher.view.compose.navigation

import com.bangpq.balancewatcher.R

sealed class NavigationBarItem(
    val route: String,
    val title: String,
    val icon: Int,
    val icon_selected: Int
) {
    object Home : NavigationBarItem(
        route = "home",
        title = "Home",
        icon = R.drawable.ic_home,
        icon_selected = R.drawable.ic_selected_home
    )

    object Statistics : NavigationBarItem(
        route = "statistics",
        title = "Statistics",
        icon = R.drawable.ic_statistics,
        icon_selected = R.drawable.ic_selected_statistics
    )

    object Transaction : NavigationBarItem(
        route = "transaction",
        title = "Transaction",
        icon = R.drawable.ic_transaction,
        icon_selected = R.drawable.ic_selected_transaction
    )

    object Profile : NavigationBarItem(
        route = "profile",
        title = "Profile",
        icon = R.drawable.ic_profile,
        icon_selected = R.drawable.ic_selected_profile
    )
}