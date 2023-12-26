package com.example.findpairgame.Screens

import android.provider.CalendarContract.Colors
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.findpairgame.R
import com.example.findpairgame.navigation.Screen

@Composable
fun MainScreen(score: Int?,navController: NavHostController) {
    var score by remember{ mutableStateOf(score)}
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Text(text = "Find a Pair", fontSize = 64.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Gray)

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
            horizontalArrangement = Arrangement.End) {
            Spacer(modifier = Modifier)
            Spacer(modifier = Modifier)

            Card(modifier = Modifier.size(width = 124.dp, height = 52.dp))
            {
                Column(modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.Gray),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Row {
                        Image(
                            modifier = Modifier
                                .size(42.dp)
                                .padding(end = 4.dp),
                            painter = painterResource(id = R.drawable.coinicon),
                            contentDescription = ""
                        )
                        Text(text = "$score", fontSize = 32.sp,
                            color = Color.White)
                    }
                }
            }
        }

        Box(modifier = Modifier)
        {
            Image(painter = painterResource(id = R.drawable.logoicon),
                contentDescription = "test",
                colorFilter = ColorFilter.tint(Color.Gray))
        }

        Button(onClick = {
            navController.navigate(route = Screen.GameScreen.passScore(score!!)) },
            colors = ButtonDefaults.buttonColors(
            Color.Gray)) {
            Text(text = "PLAY", fontSize = 52.sp, color = Color.White)
        }


        Card(modifier = Modifier.size(width = 284.dp, height = 72.dp))
        {
            Column(modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Gray),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                )
                {
                    Image(
                        modifier = Modifier.size(64.dp)
                            .padding(start = 16.dp),
                        painter = painterResource(id = R.drawable.settingsicon),
                        contentDescription = "Settings",
                        colorFilter = ColorFilter.tint(Color.White),

                    )

                    Image(
                        modifier = Modifier.size(64.dp)
                            .padding(end = 16.dp),
                        painter = painterResource(id = R.drawable.privacyicon),
                        contentDescription = "Privacy",
                        colorFilter = ColorFilter.tint(Color.White)
                    )


                }
            }
        }

    }
}