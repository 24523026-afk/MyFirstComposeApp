package com.example.myfirstcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myfirstcomposeapp.ui.theme.MyFirstComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyFirstComposeAppTheme {
                MyFirstScreen()
            }
        }
    }
}

@Composable
fun MyFirstScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Text(text = "Hi! I am Aufa.")
        Text(text = "My idea: a Campus Event Planner.")
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "App launcher icon"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MyFirstScreenPreview() {
    MyFirstComposeAppTheme {
        MyFirstScreen()
    }
}