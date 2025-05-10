package com.example.jetpackcomposeassignment1.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.jetpackcomposeassignment1.data.model.Course
import com.example.jetpackcomposeassignment1.presentation.components.CourseCard
import com.example.jetpackcomposeassignment1.ui.colors.colorGrayBackground
import com.example.jetpackcomposeassignment1.ui.colors.colorHeading
import com.example.jetpackcomposeassignment1.ui.colors.colorTextField

@Composable
fun CourseListenScreen(navigateBack:()->Unit, courses: List<Course>) {
    // Top Row with back button and title
    Column(
        modifier = Modifier.fillMaxSize()
            .background(color = colorGrayBackground)
            .padding(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
                .padding(top = 16.dp, bottom = 16.dp)
        ) {
            IconButton(onClick = { navigateBack()}) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.Black
                )
            }

        }

        // Course List
        LazyColumn {
            items(courses) { course ->
                CourseCard(course = course)
            }
        }
    }
}
