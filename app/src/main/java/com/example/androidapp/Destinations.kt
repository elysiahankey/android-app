package com.example.androidapp

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import kotlinx.serialization.Serializable

interface Destination {
    val name: String
    val route: String
    val icon: @Composable () -> Unit
}

@Serializable
object Welcome : Destination {
    override val name = "Welcome"
    override val route = "welcome"
    override val icon = @androidx.compose.runtime.Composable {
        Icon(
            painterResource(R.drawable.ic_home),
            contentDescription = null
        )
    }
}

@Serializable
object Home : Destination {
    override val name = "Home"
    override val route = "home"
    override val icon = @androidx.compose.runtime.Composable {
        Icon(
            painterResource(R.drawable.ic_home),
            contentDescription = null
        )
    }
}

@Serializable
object Search : Destination {
    override val name = "Search"
    override val route = "search"
    override val icon = @androidx.compose.runtime.Composable {
        Icon(
            painterResource(R.drawable.ic_search),
            contentDescription = null
        )
    }
}

@Serializable
object MyBooks : Destination {
    override val name = "My Books"
    override val route = "my_books"
    override val icon = @androidx.compose.runtime.Composable {
        Icon(
            painterResource(R.drawable.ic_book),
            contentDescription = null
        )
    }
}

val topLevelRoutes = listOf(Home, Search, MyBooks)