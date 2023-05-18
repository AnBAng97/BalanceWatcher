package com.bangpq.balancewatcher.view.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.bangpq.balancewatcher.R
import com.bangpq.balancewatcher.view.compose.navigation.NavigationBar
import com.bangpq.balancewatcher.view.compose.navigation.NavigationBarItem
import kotlinx.coroutines.delay


@Preview
@Composable
fun Preview() {
    SplashScreen.Body()
}

object SplashScreen {

    @Composable
    fun Screen(navController: NavHostController) {

        Scaffold(
            backgroundColor = Color.White
        ) { contentPadding ->
            Box(modifier = Modifier.padding(contentPadding)) {
                Body()
                LaunchedEffect(Unit){
                    delay(2000)
                    navController.popBackStack()
                    navController.navigate("home_navigation")
                }
            }
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
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_splash),
                    contentDescription = "Splash",
                    modifier = Modifier
                        .height(250.dp)
                        .width(250.dp)
                        .padding(25.dp),
                    contentScale = ContentScale.Fit,
                )
                Text(
                    text = "BALANCE WATCHER",
                    fontSize = 26.sp,
                    fontWeight =  FontWeight.Bold,
                    color = Color.Gray
                )
            }
        }
    }
}