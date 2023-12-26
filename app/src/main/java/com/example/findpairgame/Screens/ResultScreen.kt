package com.example.findpairgame.Screens

import android.graphics.ColorFilter
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.findpairgame.R
import com.example.findpairgame.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResultScreen(score: Int?,navController: NavHostController){
    var score by remember {
        mutableStateOf(score)
    }
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    )
    {
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
        )
        {
            Image(modifier = Modifier.size(300.dp),
                painter = painterResource(id = R.drawable.winicon),
                contentDescription = "Winicon")
            Text(text = "CONGRATULATION!", fontSize = 38.sp, fontWeight = FontWeight.Bold)
            Text(text = "Great! You won!", fontSize = 28.sp, fontWeight = FontWeight.Bold)


        }

        Card(modifier = Modifier.size(width = 300.dp, height = 82.dp)) {
            Column(modifier = Modifier.fillMaxSize()
                .background(color = Color.Gray),
                verticalArrangement = Arrangement.Center) {

                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically) {
                    Image(modifier = Modifier
                        .size(42.dp)
                        .padding(end = 4.dp),painter = painterResource(id = R.drawable.coinicon), contentDescription = "")
                    Text(text = "$score", fontSize = 32.sp, color = Color.White)
                }
            }
        }

        Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly)
        {
            Button(modifier = Modifier.size(184.dp, 72.dp),
                onClick = { score = score?.times(2) },
                colors = ButtonDefaults.buttonColors(
                Color.Gray
            ))
            {
                Text(text = "Double Reward", fontSize = 18.sp, color = Color.White)

            }


            Card(modifier = Modifier.size(72.dp),
                onClick = {
                    navController.navigate(Screen.HomeScreen.passScore(score!!))
                }) {
                Column(modifier = Modifier.fillMaxSize()
                    .background(color = Color.Gray),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(modifier = Modifier.size(52.dp), colorFilter = androidx.compose.ui.graphics.ColorFilter.tint(Color.White),
                        painter = painterResource(id = R.drawable.homeicon) ,
                        contentDescription = "homeicon")
                }
            }

        }


    }
}