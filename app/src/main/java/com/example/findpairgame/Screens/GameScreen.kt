package com.example.findpairgame.Screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.findpairgame.R
import com.example.findpairgame.model.PictureModel
import com.example.findpairgame.model.PictureViewModel
import com.example.findpairgame.navigation.Screen
import kotlinx.coroutines.delay


@Composable
fun GameScreen(viewModel: PictureViewModel,navController: NavHostController){

    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center)
    {
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly){
            Timer(totalTime = 60L * 1000L,
                modifier = Modifier.size(200.dp))


            Row {
                Image(modifier = Modifier
                    .size(42.dp)
                    .padding(end = 4.dp),painter = painterResource(id = R.drawable.coinicon), contentDescription = "")
                Text(text = "100", fontSize = 32.sp)
            }
        }



        val cards: List<PictureModel> by viewModel.getPictures().observeAsState(listOf())
        CardsGrid(cards = cards, viewModel,navController)



    }

}


@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun CardsGrid(cards: List<PictureModel>, viewModel: PictureViewModel,navController: NavHostController){
    LazyVerticalGrid(columns = GridCells.Fixed(4)){
        items(cards.count()){
                cardIndex ->
            CardItem(cards[cardIndex], viewModel, navController)
        }
    }
}

@Composable
private fun CardItem(picture: PictureModel, viewModel: PictureViewModel,navController: NavHostController){
    Box(
        modifier = Modifier
            .padding(10.dp)
    )
    {
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .size(150.dp)
                .background(
                    color = Color.Black.copy(alpha = if (picture.isVisible) 0.4f else 0.0f),
                    shape = RoundedCornerShape(10.dp)
                )
                .clickable {
                    if (picture.isVisible) {
                        viewModel.updateShowVisibleCard(picture.id, navController = navController)
                    }
                }
        ) {
            if (picture.isSelect){
                Text(text = picture.char,
                    fontSize = 32.sp)
            }

        }
    }
}


@Composable
fun Timer(
    totalTime: Long,
    modifier: Modifier = Modifier,
    initialValue: Float = 1f,
) {
    var size by remember {
        mutableStateOf(IntSize.Zero)
    }
    var value by remember {
        mutableStateOf(initialValue)
    }
    var currentTime by remember {
        mutableStateOf(totalTime)
    }
    var isTimeRunning by remember {
        mutableStateOf(false)
    }
    LaunchedEffect(key1 = currentTime, key2 = isTimeRunning){
        if (currentTime>0 && isTimeRunning){
            delay(100L)
            currentTime -= 100L
            value = currentTime / totalTime.toFloat()
        }

    }
    Row(verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
            .onSizeChanged {
                size = it
            }
    ) {
        Image(painter = painterResource(id = R.drawable.timericon),
            contentDescription = "timer")
        Text(
            text = (currentTime / 1000L).toString(),
            fontSize = 44.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Button(
            onClick = {
                if (currentTime <=0L) {
                    currentTime = totalTime
                    isTimeRunning =true

                }else{
                    isTimeRunning = !isTimeRunning
                }
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = if (!isTimeRunning || currentTime <= 0L) {
                    Color.Cyan
                } else {
                    Color.DarkGray
                }
            )
        )
        {
            Text(
                text = if (isTimeRunning && currentTime > 0L) "Stop"
                else if (!isTimeRunning && currentTime > 0L) "Start"
                else "Restart"
            )
        }

    }
}

fun nextScreen(navController: NavHostController){
    navController.navigate(Screen.GameScreen.route)
}