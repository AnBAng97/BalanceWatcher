package com.bangpq.balancewatcher.view.compose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.bangpq.balancewatcher.view.compose.ProfileScreen
import com.bangpq.balancewatcher.view.compose.SplashScreen
import com.bangpq.balancewatcher.view.compose.homescreen.HomeScreen

@Composable
fun RootNavigation(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        route = "root_nav",
        startDestination = "splash_navigation"
    ) {
        splashNavigation(navController = navController)
        composable(route = "home_navigation") {
            HomeScreen.Screen()
        }
    }
}
