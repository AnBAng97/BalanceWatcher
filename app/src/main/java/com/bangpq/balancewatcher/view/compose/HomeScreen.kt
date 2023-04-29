package com.bangpq.balancewatcher.view.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bangpq.balancewatcher.R

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen.Screen()
}

object HomeScreen {
    @Composable
    fun Screen() {
        Scaffold(backgroundColor = Color.White,
            topBar = {
                TopBar()
            },
            bottomBar = {
                SootheBottomNavigation(Modifier.background(color = Color.White))
            }) { contentPadding ->
            Box(modifier = Modifier.padding(contentPadding)) {
                Body()
            }
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

    @Composable
    fun SootheBottomNavigation(modifier: Modifier = Modifier) {
        BottomNavigation(
            modifier = modifier,
            contentColor = Color(10, 169, 192, 125),
            backgroundColor = MaterialTheme.colors.background,
        ) {
            BottomNavigationItem(
                icon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_home),
                        contentDescription = null
                    )
                },
                selected = true,
                onClick = {},
                selectedContentColor = Color(10, 169, 192, 255),
                unselectedContentColor = Color(10, 169, 192, 100)
            )

            BottomNavigationItem(
                icon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_statistics),
                        contentDescription = null
                    )
                },
                selected = false,
                onClick = {},

                selectedContentColor = Color(10, 169, 192, 255),
                unselectedContentColor = Color(10, 169, 192, 100)
            )
            BottomNavigationItem(
                icon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_transaction),
                        contentDescription = null
                    )
                },
                selected = false,
                onClick = {},

                selectedContentColor = Color(10, 169, 192, 255),
                unselectedContentColor = Color(10, 169, 192, 100)
            )
            BottomNavigationItem(
                icon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_profile),
                        contentDescription = null
                    )

                },
                selected = false,
                onClick = {},

                selectedContentColor = Color(10, 169, 192, 255),
                unselectedContentColor = Color(10, 169, 192, 100)
            )
        }
    }
}