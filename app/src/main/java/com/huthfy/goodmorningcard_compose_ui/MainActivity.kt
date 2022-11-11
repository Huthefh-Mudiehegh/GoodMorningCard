package com.huthfy.goodmorningcard_compose_ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.huthfy.goodmorningcard_compose_ui.ui.theme.GoodMorningCardComposeUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GoodMorningCardComposeUITheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    GoodMorningCard(message = stringResource(R.string.good_morning_message), from = "Huthefh")

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun GoodMorningCard(message: String, from: String) {
    val image = painterResource(id = R.drawable.good_morning_card)
    Box{
        Image(painter = image,
            contentDescription = null,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            contentScale = ContentScale.Crop)
        GoodMorningText(message = message, from = from)
    }

}

@Composable
fun GoodMorningText(message: String, from: String) {
    Column {

        Text(text = message,
            fontSize = 32.sp,
            modifier = Modifier
                .padding(top = 16.dp, start = 16.dp)
                .background(Color(0x99FFFFFF)))

        Text(text = stringResource(id = R.string.good_morning_greeting)+" $from",
            fontSize = 20.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.Start)
                .padding(top = 6.dp, start = 16.dp))
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GoodMorningCardComposeUITheme {
        GoodMorningCard(message = stringResource(R.string.good_morning_message), from = "Huthefh")
    }
}