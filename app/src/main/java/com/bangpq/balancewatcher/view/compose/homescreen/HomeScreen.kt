package com.bangpq.balancewatcher.view.compose.homescreen

import androidx.compose.foundation.*
import com.bangpq.balancewatcher.view.compose.Colors
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.bangpq.balancewatcher.R
import com.bangpq.balancewatcher.view.compose.navigation.HomeNavigation
import com.bangpq.balancewatcher.view.compose.navigation.NavigationBar

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen.Screen()
}

object HomeScreen {
    @Composable
    fun Screen(
        navController: NavHostController = rememberNavController()
    ) {
        Scaffold(backgroundColor = Color.White,
//            topBar = { TopBar() },
            bottomBar = { NavigationBar.BottomBar(navController = navController) }
        )
        {
            Modifier.padding(it)
            HomeNavigation(navController = navController)
        }
    }


    @Composable
    fun Body() {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .background(Color.White)
                .fillMaxSize()
        ) {
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(bottom = 53.dp).fillMaxSize()
            ) {
                TopBar()
                Balance()
                OptionBar()
                RecentTransaction()
                Text(
                    text = "Balance Watcher", fontSize = 30.sp, fontStyle = FontStyle.Italic
                )
            }
        }
    }

    @Composable
    fun TopBar() {
        Row(
            modifier = Modifier
                .padding(start = 24.dp, end = 24.dp, top = 35.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = "Welcome", fontSize = 16.sp, color = Colors.cyan
                )
                Text(
                    text = "Lord Voldemort",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Colors.cyan
                )
            }

            Icon(
                painter = painterResource(id = R.drawable.ic_notification),
                contentDescription = "notification bell",
                tint = Colors.cyan,
                modifier = Modifier.clickable(onClick = {})
            )

        }
    }

    @Composable
    fun Balance() {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(130.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "Balance", fontSize = 20.sp, color = Colors.cyan
            )
            Text(
                text = "1000,000,000 VND",
                fontSize = 32.sp,
                fontWeight = FontWeight.SemiBold,
                color = Colors.cyan
            )
        }
    }

    @Composable
    fun OptionBar() {
        val optionItems =
            listOf(OptionItem.Send, OptionItem.CardPayment, OptionItem.Scan, OptionItem.More)
        Row(
            modifier = Modifier
                .padding(start = 42.dp, end = 42.dp)
                .fillMaxWidth()
                .height(106.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            optionItems.forEach { item ->
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(56.dp),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Card(
                        modifier = Modifier
                            .height(56.dp)
                            .width(56.dp)
                            .clickable(onClick = {

                            }),
                        shape = RoundedCornerShape(15.dp),
                        backgroundColor = Colors.cyan,
                        contentColor = Color.White
                    ) {
                        Icon(
                            painter = painterResource(id = item.icon), contentDescription = null,
//                        contentScale = ContentScale.Fit,
                            modifier = Modifier.padding(16.dp), tint = Color.White
                        )
                    }
                    Text(
                        text = item.displayName,
                        fontSize = 14.sp,
                        color = Colors.cyan,
                        textAlign = TextAlign.Center
                    )
                }

            }

        }
    }


    @Composable
    fun RecentTransaction() {
        val recentTransactionList = listOf(1, 2, 3, 4)
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(46.dp)
                    .border(
                        border = BorderStroke(1.dp, Colors.cyan),
                        shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)
                    )
                    .padding(start = 24.dp, end = 24.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Recent Transactions", color = Colors.cyan, fontSize = 16.sp
                )
                Text(
                    text = "See all",
                    color = Colors.cyan,
                    fontSize = 16.sp,
                    style = TextStyle(textDecoration = TextDecoration.Underline),
                    modifier = Modifier.clickable(onClick = {

                    })
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(Colors.cyan)
                    .padding(start = 24.dp, end = 24.dp),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                recentTransactionList.forEach {
                    AddRecentTransaction(it)
                }
            }
        }
    }

    @Composable
    private fun AddRecentTransaction(i: Int) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
                .padding(start = 17.dp, end = 10.dp)
                .clip(shape = RoundedCornerShape(10))
                .background(Color.White)
                ,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_bidv),
                contentDescription = null,
                contentScale = ContentScale.Inside,
                modifier = Modifier
                    .width(80.dp)
                    .height(50.dp)
            )
            Column(
                modifier = Modifier
                    .width(175.dp)
                    .height(30.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "BIDV",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(72,93,166)
                )
                Text(
                    text = "17 August 2022",
                    fontSize = 8.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Gray
                )
            }
            Column(
                modifier = Modifier
                    .width(175.dp)
                    .height(30.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "-400",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Red
                )
                Text(
                    text = "Shopping",
                    fontSize = 8.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Gray
                )
            }
        }

    }


}

