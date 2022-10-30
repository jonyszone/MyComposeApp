package com.example.myapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapp.bank.BankingActivity
import com.example.myapp.hero.MiniGameActivity
import com.example.myapp.hero.ProgrammingHeroActivity
import com.example.myapp.hero.StartGameActivity
import com.example.myapp.ui.theme.MyAppTheme

class MainActivityComposable : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainContent()
            Greeting(firstName = "MY", lastName = "HEAD")
        }
    }


    @Composable
    private fun MainContent() {
        MyAppTheme {
            Greeting(firstName = "My", lastName = "Head")
        }
    }
}


@Composable
fun Greeting(firstName: String, lastName: String) {
    val context = LocalContext.current
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFFB3B3B3)),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = R.drawable.ic_android_black_head),
            contentDescription = "Android Head",
            modifier = Modifier
                .size(250.dp, 150.dp)
                .clickable(
                    enabled = true,
                    onClickLabel = "Clickable Android Image",
                    onClick = {
                        context.startActivity(Intent(context, BankingActivity::class.java))
                    }
                )
        )

        Text(fontSize = 26.sp,
            style = MaterialTheme.typography.h1,
            text = "Click $firstName! $lastName")


        Button(
            // below line is use to add onclick
            onClick = {
                //Toast.makeText(context, "Welcome to Programming Hero", Toast.LENGTH_LONG).show()
                context.startActivity(Intent(context, StartGameActivity::class.java))
            },
            modifier = Modifier.padding(all = Dp(10F)),
            enabled = true,
            border = BorderStroke(width = 1.dp, brush = SolidColor(Color.Blue)),
            shape = MaterialTheme.shapes.medium,
        )
        {
            Text(text = "Programming Hero", color = Color.White)
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyAppTheme {
        Greeting("My", "Studio")
    }
}