package com.berfinsvrn.sayac

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.berfinsvrn.sayac.ui.theme.SayacTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SayacTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Counter()
                }
            }
        }
    }
}

@Composable
fun Counter()
{
    var counter = remember {
        mutableStateOf(0)
    };
    Box (modifier = Modifier
        .fillMaxWidth(1f)
        .fillMaxHeight(1f)
        .background(color = Color(202, 237, 255))){
        Column(modifier = Modifier
            .fillMaxHeight(1f)
            .fillMaxWidth(1f), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Counter", fontSize = 90.sp, fontWeight = FontWeight.Bold, color = Color(14, 33, 160))
            Spacer(modifier = Modifier.height(80.dp))
            CounterText(number = counter.value)
            Spacer(modifier = Modifier.height(15.dp))
            Row (modifier = Modifier.fillMaxWidth(1f), horizontalArrangement = Arrangement.Center){
                IncreaseButton(inc_function = {
                    counter.value = counter.value + 1
                    println("Counter:" + counter)
                })
                Spacer(modifier = Modifier.width(50.dp))
                DecreaseButton(dec_function = {
                    counter.value = counter.value -1
                    println("Counter:" + counter)
                })
            }
            Spacer(modifier = Modifier.height(30.dp))
            ResetButton(reset_function = {
                counter.value = 0
            })
        }
    }
}
@Composable
fun CounterText(number:Int){

    Text(text = number.toString(), fontSize = 80.sp, color = Color(77, 45, 183))
}
@Composable
fun IncreaseButton(inc_function:()->Unit){
    Button(onClick = { inc_function() }, shape = RoundedCornerShape(15.dp) ,
        modifier = Modifier.size(80.dp).border(width = 2.dp, color = Color.White, shape = RoundedCornerShape(15.dp)),
        colors = ButtonDefaults
            .buttonColors(containerColor = Color(216, 180, 248), contentColor = Color(77, 45, 183))) {
        Text(text = "+", fontSize = 40.sp)
    }
}
@Composable
fun DecreaseButton(dec_function:()->Unit){
    Button(onClick = { dec_function() }, shape = RoundedCornerShape(15.dp), modifier = Modifier
        .size(80.dp)
        .border(width = 2.dp, color = Color.White, shape = RoundedCornerShape(15.dp))
    ,colors = ButtonDefaults
            .buttonColors(containerColor = Color(216, 180, 248))) {
        Text(text = "-", fontSize = 40.sp, color = Color(77, 45, 183))
    }
}
@Composable
fun ResetButton(reset_function:()->Unit){
    Button(onClick = { reset_function() }, shape = RoundedCornerShape(10.dp)
        ,colors = ButtonDefaults
        .buttonColors(containerColor = Color(216, 180, 248), contentColor = Color(77, 45, 183))
        , modifier = Modifier.border(width = 2.dp, color = Color.White , shape = RoundedCornerShape(10.dp))) {
        Text(text = "Reset", fontSize = 38.sp)
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    SayacTheme {
        Counter()
    }
}