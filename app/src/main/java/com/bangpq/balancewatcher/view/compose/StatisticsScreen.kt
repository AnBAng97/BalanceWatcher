package com.bangpq.balancewatcher.view.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.bangpq.balancewatcher.R
import com.bangpq.balancewatcher.view.compose.navigation.RootNavigation

@Preview
@Composable
fun StatisticsScreenPreview() {
    StatisticsScreen.Screen()
}

object StatisticsScreen {
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
            RootNavigation(
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
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 35.dp, bottom = 5.dp)
                .clip(shape = RoundedCornerShape(bottomStart = 15.dp, bottomEnd = 15.dp)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Transaction History",
                color = Colors.cyan,
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
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

