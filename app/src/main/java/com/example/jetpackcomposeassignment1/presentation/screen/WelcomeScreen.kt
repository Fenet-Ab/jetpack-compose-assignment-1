package com.example.jetpackcomposeassignment1.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.jetpackcomposeassignment1.ui.colors.colorGrayBackground
import com.example.jetpackcomposeassignment1.ui.colors.colorHeading

@Composable
fun WelcomeScreen(navigateToCourseList:() -> Unit) {

    Column (

        modifier = Modifier.fillMaxSize()
            .background(color= colorGrayBackground),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text="Welcome to Course List App",
            style= TextStyle(
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                color = colorHeading
            )
        )
        Spacer(modifier=Modifier.height(16.dp))
        Button(onClick = {
            navigateToCourseList()
        },
            modifier = Modifier.padding(16.dp)
                .width(100.dp)) {
            Text(text = "Start")
        }
    }
}
