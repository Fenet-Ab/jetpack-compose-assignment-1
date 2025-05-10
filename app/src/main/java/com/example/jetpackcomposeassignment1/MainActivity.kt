package com.example.jetpackcomposeassignment1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import com.example.jetpackcomposeassignment1.data.model.Course
import com.example.jetpackcomposeassignment1.presentation.screen.CourseListenScreen
import com.example.jetpackcomposeassignment1.presentation.screen.WelcomeScreen
import com.example.jetpackcomposeassignment1.ui.theme.JetpackComposeAssignment1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val sampleCourses = listOf(
                Course("Intro to Programming", "CS101", 3, "Learn programming basics.", "None"),
                Course("Data Structures", "CS201", 4, "Explore arrays, trees, and graphs.", "CS101"),
                Course("Operating Systems", "CS301", 3, "Understand process management.", "CS201"),
                Course("Database", "CS401", 3, "Learn database basics.", "None"),
                Course("Web Development", "CS501", 4, "learn website development.", "CS101"),
                Course("Android Development", "CS601", 3, "learn Android development.", "CS201"),
                Course("Fundamental of AI", "CS701", 3, "Learn basics of AI.", "None"),
                Course("Fundamental of Cyber", "CS801", 2, "Learn basics of cyber", "CS101"),
                Course("Graphics Design", "CS901", 3, "Understand Graphics Design.", "CS201")
            )


            JetpackComposeAssignment1Theme {
                // This provides MaterialTheme context (required by Surface)
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = "welcomeScreen") {
                        composable(route="welcomeScreen") {
                            WelcomeScreen(navigateToCourseList ={
                                navController.navigate("courseList")

                            } )
                        }
                        composable(route="courseList") {
                            CourseListenScreen(navigateBack = {
                                navController.navigate("welcomeScreen")
                            }, courses = sampleCourses)
                        }
                    }
                }


        }
        }
    }
}
