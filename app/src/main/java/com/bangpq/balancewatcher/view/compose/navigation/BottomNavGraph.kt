package com.bangpq.balancewatcher.view.compose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.bangpq.balancewatcher.view.compose.homescreen.HomeScreen

@Composable
fun BottomNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = NavigationBarItem.Home.route
    ) {
        composable(route = NavigationBarItem.Home.route) {
            HomeScreen.Screen()
        }
        composable(route = NavigationBarItem.Statistics.route) {
//            ReportScreen()
        }
        composable(route = NavigationBarItem.Transaction.route) {
//            ProfileScreen()
        }
        composable(route = NavigationBarItem.Profile.route) {
//            ProfileScreen()
        }
    }
}
