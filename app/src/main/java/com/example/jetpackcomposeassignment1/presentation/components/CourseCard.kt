package com.example.jetpackcomposeassignment1.presentation.components

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropUp

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposeassignment1.data.model.Course
import com.example.jetpackcomposeassignment1.ui.colors.*

@Composable
fun CourseCard(course: Course, modifier: Modifier = Modifier) {
    var isExpanded by rememberSaveable { mutableStateOf(false) }

    Card(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable { isExpanded = !isExpanded },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.background)
    ) {
        Column(
            modifier = Modifier
                .background(color = white)
                .padding(16.dp)
                .animateContentSize()
        ) {
            Text(
                text = course.title,
                style = MaterialTheme.typography.titleLarge,
                color = colorHeading, // Changed from onPrimary to visible color
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp)
            )

            Spacer(Modifier.height(8.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, bottom = 10.dp)
            ) {
                Text(
                    text = "Code: ${course.code}",
                    style = MaterialTheme.typography.bodyLarge,
                    textAlign = TextAlign.Left,
                    color = colorGray
                )

                Text(
                    text = "Credits: ${course.creditHours}",
                    style = MaterialTheme.typography.bodyLarge,
                    textAlign = TextAlign.Left,
                    color = colorGray
                )
                IconButton(
                    onClick = { isExpanded = !isExpanded },
                    modifier = Modifier.size(24.dp)
                ) {
                    Icon(
                        imageVector = if (isExpanded)
                            Icons.Filled.ArrowDropUp else
                            Icons.Filled.ArrowDropDown,
                        contentDescription = if (isExpanded) "Collapse" else "Expand",
                        tint = colorGray
                    )
                }
            }


            if (isExpanded) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Description: ${course.description}",
                    style = MaterialTheme.typography.bodySmall,
                    textAlign = TextAlign.Left,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "Prerequisites: ${course.prerequisites}",
                    style = MaterialTheme.typography.bodySmall,
                    textAlign = TextAlign.Left,
                    color = Color.Gray
                )
            }
        }
    }
}
