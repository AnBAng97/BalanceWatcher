package com.bangpq.balancewatcher.view.compose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.bangpq.balancewatcher.view.compose.ProfileScreen
import com.bangpq.balancewatcher.view.compose.TransactionScreen
import com.bangpq.balancewatcher.view.compose.homescreen.HomeScreen

@Composable
fun HomeNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = "home_navigation",
        startDestination = NavigationBarItem.Home.route
    ) {
        composable(route = NavigationBarItem.Home.route) {
            HomeScreen.Body()
        }
        composable(route = NavigationBarItem.Statistics.route) {
//            ReportScreen()
        }
        composable(route = NavigationBarItem.Transaction.route) {
            TransactionScreen.Screen()
        }
        composable(route = NavigationBarItem.Profile.route) {
//            ProfileScreen()
        }
    }
}