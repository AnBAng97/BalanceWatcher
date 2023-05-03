package com.bangpq.balancewatcher.view.compose.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.bangpq.balancewatcher.view.compose.Colors
import com.bangpq.balancewatcher.view.compose.noRippleClickable

object NavigationBar {
    @Composable
    fun BottomBar() {
        val navController = rememberNavController()

        Scaffold(backgroundColor = Color.White,
            bottomBar = {
                BottomBar(navController = navController)
            }) {
            Modifier.padding(it)
            BottomNavGraph(
                navController = navController
            )
        }
    }

    @Composable
    fun BottomBar(navController: NavHostController) {
        val screens = listOf(
            NavigationBarItem.Home,
            NavigationBarItem.Statistics,
            NavigationBarItem.Transaction,
            NavigationBarItem.Profile
        )
        val navStackBackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navStackBackEntry?.destination
        Row(
            modifier = Modifier
                .padding(start = 8.dp, end = 8.dp, top = 8.dp, bottom = 8.dp)
                .background(Color.Transparent)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            screens.forEach { screen ->
                AddItem(
                    screen = screen,
                    currentDestination = currentDestination,
                    navController = navController
                )
            }

        }
    }

    @Composable
    fun RowScope.AddItem(
        screen: NavigationBarItem,
        currentDestination: NavDestination?,
        navController: NavHostController
    ) {
        val selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true

        Box(
            modifier = Modifier
                .height(40.dp)
                .clip(CircleShape)
                .noRippleClickable {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.findStartDestination().id)
                        launchSingleTop = true
                    }
                }
//                .clickable(onClick = {
//                    navController.navigate(screen.route) {
//                        popUpTo(navController.graph.findStartDestination().id)
//                        launchSingleTop = true
//                    }
//                })
        ) {
            Row(
                modifier = Modifier
                    .padding(start = 10.dp, end = 10.dp, top = 8.dp, bottom = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Icon(
                    painter = painterResource(id = if (selected) screen.icon_selected else screen.icon),
                    contentDescription = null,
                    tint = Colors.cyan,
                )
                this@AddItem.AnimatedVisibility(visible = selected) {
                    Text(
                        text = screen.title,
                        color = Colors.cyan
                    )
                }
            }
        }
    }
}