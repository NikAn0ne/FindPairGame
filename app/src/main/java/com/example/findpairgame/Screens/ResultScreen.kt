package com.example.findpairgame.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.findpairgame.R
import com.example.findpairgame.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResultScreen(navController: NavHostController){
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
            Column(modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center) {

                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically) {
                    Image(modifier = Modifier
                        .size(42.dp)
                        .padding(end = 4.dp),painter = painterResource(id = R.drawable.coinicon), contentDescription = "")
                    Text(text = "100", fontSize = 32.sp)
                }
            }
        }

        Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly)
        {
            Button(modifier = Modifier.size(184.dp, 72.dp),onClick = { /*TODO*/ })
            {
                Text(text = "Double Reward", fontSize = 18.sp)

            }


            Card(modifier = Modifier.size(72.dp),
                onClick = {
                    navController.navigate(Screen.HomeScreen.route)
                }) {
                Column(modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(modifier = Modifier.size(52.dp),
                        painter = painterResource(id = R.drawable.homeicon) ,
                        contentDescription = "homeicon")
                }
            }

        }


    }
}