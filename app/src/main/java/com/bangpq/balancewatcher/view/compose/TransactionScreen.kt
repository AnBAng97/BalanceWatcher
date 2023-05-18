package com.bangpq.balancewatcher.view.compose

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
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
fun TransactionScreenPreview() {
    TransactionScreen.Screen()
}

object TransactionScreen {
    @Composable
    fun Screen() {
        Scaffold(backgroundColor = Color.White,
            topBar = {
                TopBar()
            }) {
            Modifier.padding(it)
            Body(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Colors.cyan)
            )
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
    fun Body(modifier: Modifier) {
        val countryList =
            (1..100).toList()
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(Colors.cyan)
                .padding(start = 24.dp, end = 24.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Add a single item
            items(countryList) { each ->
                Spacer(modifier = Modifier.height(15.dp))
                AddTransaction()
            }
        }
    }


    @Composable
    fun AddTransaction() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
                .padding(start = 17.dp, end = 10.dp)
                .clip(shape = RoundedCornerShape(10))
                .background(Color.White),
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
                    color = Color(72, 93, 166)
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

