package com.bangpq.balancewatcher.view.compose.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.bangpq.balancewatcher.view.compose.SplashScreen

fun NavGraphBuilder.splashNavigation(navController: NavHostController) {
    navigation(route = "splash_navigation", startDestination = "splash") {
        composable(route = "splash") {
            SplashScreen.Screen(navController = navController)
        }
    }
}
