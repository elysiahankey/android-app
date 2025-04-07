package com.example.androidapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.androidapp.mybooks.MyBooksScreen
import com.example.androidapp.search.SearchScreen
import com.example.androidapp.welcome.WelcomeScreen

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

@Composable
fun NavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Welcome.route,
    ) {
        composable(route = Welcome.route) {
            WelcomeScreen(
                onClickGetStarted = { navController.navigateSingleTopTo(Search.route) }
            )
        }
        composable(route = Search.route) {
            SearchScreen()
        }
        composable(route = MyBooks.route) {
            MyBooksScreen()
        }
    }
}

fun NavHostController.navigateSingleTopTo(route: String) =
    this.navigate(route) {
        popUpTo(
            this@navigateSingleTopTo.graph.findStartDestination().id
        ) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }