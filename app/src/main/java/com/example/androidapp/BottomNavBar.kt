package com.example.androidapp

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.androidapp.home.HomeScreen
import com.example.androidapp.mybooks.MyBooksScreen
import com.example.androidapp.search.SearchScreen
import com.example.androidapp.welcome.WelcomeScreen

@Composable
fun BottomNavBar(navController: NavHostController) {
    BottomNavigation {
//        val shouldShowBottomBar: Boolean
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        topLevelRoutes.forEach { topLevelRoute ->
            BottomNavigationItem(
                icon = { topLevelRoute.icon },
                label = { Text(topLevelRoute.name) },
                selected = currentDestination?.hierarchy?.any {
                    it.hasRoute(
                        topLevelRoute.route::class
                    )
                } == true,
                onClick = {
                    navController.navigateSingleTopTo(topLevelRoute.route)
                }
            )
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
        composable(route = Home.route) {
            HomeScreen()
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