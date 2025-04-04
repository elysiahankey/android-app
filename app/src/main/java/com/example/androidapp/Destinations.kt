package com.example.androidapp

import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

interface Destination {
    val route: String
    val screen: @Composable () -> Unit
}

object HomeScreen : Destination {
    override val route = "overview"
    override val screen: @Composable () -> Unit = { HomeScreen() }
}

object SearchScreen : Destination {
    override val route = "overview"
    override val screen: @Composable () -> Unit = { SearchScreen() }
}