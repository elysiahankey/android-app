package com.example.androidapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BookshelfApp()
        }
    }
}

@Composable
fun BookshelfApp() {
    AppTheme {
        var navController = rememberNavController()
        Scaffold(
            bottomBar = {
                    BottomNavBar(navController)
            }
        ) { innerPadding ->
            NavHost(navController)
        }
    }
}