package com.example.android_declarative.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.android_declarative.ui.theme.Android_declarativeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Android_declarativeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
//                    MainScreen()
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "main"
                    ) {
                        composable(
                            route = "main"
                        ) {
                            MainScreen(
                                navController = navController
                            )
                        }
                        composable(
                            route = "details"
                        ) {
                            DetailsScreen(
                                navController = navController
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun navController(): NavController{
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "main"
    ) {
        composable(
            route = "main"
        ) {
            MainScreen(
                navController = navController
            )
        }
        composable(
            route = "details"
        ) {
            DetailsScreen(
                navController = navController
            )
        }
    }
    return navController
}

@Composable
fun MainScreen(navController: NavController) {
    Scaffold(
        backgroundColor = Color.Black,
        topBar = {
            TopAppBar(
                backgroundColor = Color.Black,
                title = { Text(text = "TV Show", color = Color.White)}
            )
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = {
                navController.navigate("details")
            }) {
                Text(text = "Open")
            }
        }
    }
}

@Composable
fun DetailsScreen(navController: NavController){
    Scaffold(
        backgroundColor = Color.Black,
        topBar = {
            TopAppBar(
                backgroundColor = Color.Black,
                title = { Text(text = "TV Show", color = Color.White) })
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Gray),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Details Page")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Android_declarativeTheme {
//        MainScreen()
    }
}