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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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

@Composable
fun MainScreen(navController: NavHostController) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Text(text = "Find a Pair", fontSize = 64.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black)

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
            horizontalArrangement = Arrangement.End) {
            Spacer(modifier = Modifier)
            Spacer(modifier = Modifier)

            Row {
                Image(modifier = Modifier
                    .size(42.dp)
                    .padding(end = 4.dp),painter = painterResource(id = R.drawable.coinicon), contentDescription = "")
                Text(text = "100", fontSize = 32.sp)
            }
        }

        Box(modifier = Modifier)
        {
            Image(painter = painterResource(id = R.drawable.logoicon),
                contentDescription = "test")
        }

        Button(onClick = { navController.navigate(Screen.GameScreen.route) },
            colors = ButtonDefaults.buttonColors(
            Color.Black)) {
            Text(text = "PLAY", fontSize = 52.sp, color = Color.White)
        }

        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically)
        {
            Image(painter = painterResource(id = R.drawable.settingsicon),
                contentDescription = "Settings")

            Image(modifier = Modifier.size(92.dp),
                painter = painterResource(id = R.drawable.privacyicon),
                contentDescription = "Privacy")



        }

    }
}