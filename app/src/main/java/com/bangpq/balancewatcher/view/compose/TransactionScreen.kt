package com.bangpq.balancewatcher.view.compose

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.bangpq.balancewatcher.R
import com.bangpq.balancewatcher.view.compose.navigation.BottomNavGraph
import com.bangpq.balancewatcher.view.compose.navigation.NavigationBarItem

@Preview
@Composable
fun TransactionScreenPreview() {
    TransactionScreen.Screen()
}

object TransactionScreen {
    @Composable
    fun Screen() {
        val navController = rememberNavController()

        Scaffold(backgroundColor = Color.White,
            topBar = {
                TopBar()
            }) { contentPadding ->
            Box(modifier = Modifier.padding(contentPadding)) {
                Body()
            }
            BottomNavGraph(
                navController = navController
            )
        }
    }

    @Composable
    fun Body() {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .background(Color.White)
                .fillMaxHeight()
                .fillMaxWidth()
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.volleyball),
                    contentDescription = "Splash",
                    modifier = Modifier.padding(25.dp)
                )
                Text(
                    text = "Balance Watcher",
                    fontSize = 30.sp,
                    fontStyle = FontStyle.Italic
                )
            }
        }
    }

    @Composable
    fun TopBar() {

    }

    @Composable
    fun Balance() {

    }

    @Composable
    fun OptionBar() {

    }

    @Composable
    fun RecentTransaction() {

    }


}

