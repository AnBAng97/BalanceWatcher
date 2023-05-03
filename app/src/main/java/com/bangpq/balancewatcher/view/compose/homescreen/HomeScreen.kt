package com.bangpq.balancewatcher.view.compose.homescreen

import androidx.compose.animation.*
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
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bangpq.balancewatcher.R
import com.bangpq.balancewatcher.view.compose.noRippleClickable

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen.Screen()
}

object HomeScreen {
    @Composable
    fun Screen() {
        Scaffold(backgroundColor = Color.White,
            topBar = { TopBar() },
            bottomBar = { Spacer(modifier = Modifier.height(55.dp)) }) { contentPadding ->
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
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
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
                .padding(start = 24.dp, end = 24.dp, top = 43.dp)
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
                            painter = painterResource(id = item.icon),
                            contentDescription = null,
//                        contentScale = ContentScale.Fit,
                            modifier = Modifier.padding(16.dp),
                            tint = Color.White
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
        var visible by remember { mutableStateOf(true) }
        val density = LocalDensity.current
        AnimatedVisibility(
            visible = visible,
            enter = slideInVertically {
                // Slide in from 40 dp from the top.
                with(density) { -40.dp.roundToPx() }
            } + expandVertically(
                // Expand from the top.
                expandFrom = Alignment.Bottom
            ) + fadeIn(
                // Fade in with the initial alpha of 0.3f.
                initialAlpha = 0.3f
            ),
            exit = slideOutVertically() + shrinkVertically() + fadeOut()
        ) {
//            Text("Hello", Modifier.fillMaxWidth().height(200.dp))
        }

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
                    text = "Recent Transactions",
                    color = Colors.cyan,
                    fontSize = 16.sp
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
                    .padding(start = 24.dp, end = 24.dp, top = 15.dp, bottom = 45.dp)

            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(55.dp)
                        .background(Color.White)
                        .padding(start = 17.dp, end = 10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(

                        painter = painterResource(id = R.drawable.ic_bidv),
                        contentDescription = null,
                        contentScale = ContentScale.Inside,
                        modifier = Modifier
                            .width(80.dp)
                            .height(50.dp)
                    )
                }
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(15.dp)
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(55.dp)
                        .background(Color.White),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_bidv),
                        contentDescription = null
                    )
                }
            }
        }
    }

}

