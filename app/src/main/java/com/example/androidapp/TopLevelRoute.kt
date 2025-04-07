//package com.example.androidapp
//
//import androidx.compose.material3.Icon
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.res.painterResource
//import kotlinx.serialization.Serializable
//
//@Serializable
//data class TopLevelRoute<T : Any>(
//    val name: String,
//    val route: T,
//    val icon: @Composable () -> Unit
//)
//
//val topLevelRoutes = listOf(
//    TopLevelRoute("Home", Home
//    ) {
//        Icon(
//            painterResource(R.drawable.ic_home),
//            contentDescription = null
//        )
//    },
//    TopLevelRoute("Search", Search
//    ) {
//        Icon(
//            painterResource(R.drawable.ic_search),
//            contentDescription = null
//        )
//    },
//    TopLevelRoute(
//        "My Books", MyBooks
//    ) {
//        Icon(
//            painterResource(R.drawable.ic_book),
//            contentDescription = null
//        )
//    }
//)